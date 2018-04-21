# coding: utf-8

import time
import tensorflow as tf
from datetime import datetime
from keras.utils.np_utils import to_categorical
from tensorflow.examples.tutorials.mnist import input_data
mnist = input_data.read_data_sets("../MNIST_data/")
X_train1 = mnist.train.images[mnist.train.labels < 5]
y_train1 = mnist.train.labels[mnist.train.labels < 5]
X_valid1 = mnist.validation.images[mnist.validation.labels < 5]
y_valid1 = mnist.validation.labels[mnist.validation.labels < 5]
X_test1 = mnist.test.images[mnist.test.labels < 5]
y_test1 = mnist.test.labels[mnist.test.labels < 5]
y_train1 = to_categorical(y_train1, num_classes=5)
y_valid1 = to_categorical(y_valid1, num_classes=5)
y_test1 = to_categorical(y_test1, num_classes=5)


def split_folds(num_folds=3):
    train_length = len(y_train1)
    fold_size = int(train_length / num_folds)
    X_train_folds = []
    y_train_folds = []
    for i in range(num_folds):
        start = i * fold_size
        end = (i + 1) * fold_size if i + 1 < num_folds else train_length
        images = X_train1[start: end]
        labels = y_train1[start: end]
        X_train_folds.append(images)
        y_train_folds.append(labels)

    return X_train_folds, y_train_folds


def init_input():
    with tf.name_scope('input'):
        X = tf.placeholder('float', [None, 784], name='input_x')
        y = tf.placeholder('float', [None, 5], name='label_y')
    return X, y


def add_layer(input_dim, output_dim, inputs, name, activation_function=None):
    name_W = 'W_' + name
    name_b = 'b_' + name

    with tf.name_scope(name):
        with tf.name_scope('weight'):
            W = tf.get_variable(shape=[input_dim, output_dim], initializer=tf.contrib.keras.initializers.he_normal(), name=name_W)
            tf.summary.histogram(name + '/weight', W)
        with tf.name_scope('bias'):
            b = tf.Variable(tf.constant(0.1, shape=[1, output_dim]), name=name_b)
            tf.summary.histogram(name + '/bias', b)
        with tf.name_scope('Wx_plus_b'):
            Wx_plus_b = tf.add(tf.matmul(inputs, W), b)
        if activation_function is None:
            outputs = Wx_plus_b
        else:
            outputs = activation_function(Wx_plus_b)
        tf.summary.histogram(name + '/output', outputs)
        return outputs


def build_network(X, n, activation):
    h1 = add_layer(input_dim=784, output_dim=n, inputs=X, name='hidden_layer_1', activation_function=activation)
    h2 = add_layer(input_dim=n, output_dim=n, inputs=h1, name='hidden_layer_2', activation_function=activation)
    h3 = add_layer(input_dim=n, output_dim=n, inputs=h2, name='hidden_layer_3', activation_function=activation)
    h4 = add_layer(input_dim=n, output_dim=n, inputs=h3, name='hidden_layer_4', activation_function=activation)
    h5 = add_layer(input_dim=n, output_dim=n, inputs=h4, name='hidden_layer_5', activation_function=activation)
    y_hat = add_layer(input_dim=n, output_dim=5, inputs=h5, name='output_layer', activation_function=tf.nn.softmax)
    return y_hat


def init_evaluation(y, y_hat, learning_rate):
    with tf.name_scope('cross_entropy'):
        loss_function = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(labels=y, logits=y_hat))
    tf.summary.scalar('cross_entropy', loss_function)

    with tf.name_scope('train'):
        optimizer = tf.train.GradientDescentOptimizer(learning_rate=learning_rate).minimize(loss_function)

    with tf.name_scope('accuracy'):
        with tf.name_scope('correction_prediction'):
            correct_prediction_count = tf.equal(tf.argmax(y, 1), tf.argmax(y_hat, 1))
        with tf.name_scope('accuracy'):
            acc = tf.reduce_mean(tf.cast(correct_prediction_count, 'float'))
    tf.summary.scalar('accuracy', acc)

    return loss_function, optimizer, acc


def DNN(epoch, n_neurons, learning_rate, activation, batch_size, early_stopping, restore_model_name=None):
    X_train_folds, y_train_folds = split_folds()

    tf.reset_default_graph()
    act_str = str(activation).split()[1]

    training_id = '[n_neurons_%d, learning_rate_%f, activation_%s, batch_size_%d]' % (
        n_neurons, learning_rate, act_str, batch_size)
    print(training_id)
    training_id += "-" + datetime.utcnow().strftime("%Y%m%d%H%M%S")
    logdir = "tf_logs/{}/".format(training_id)

    X, y = init_input()
    y_hat = build_network(X, n_neurons, activation)
    loss_function, optimizer, acc = init_evaluation(y, y_hat, learning_rate)

    batch = int(mnist.train.num_examples / batch_size)

    start_epoch = 0
    iteration = 0

    with tf.Session() as sess:
        if restore_model_name:
            saver.restore(sess, "regular_train/" + restore_model_name)
            start_epoch = int(restore_model_name.split('.')[0].split('_')[-1])
        else:
            sess.run(tf.global_variables_initializer())

        merged = tf.summary.merge_all()
        writer = tf.summary.FileWriter(logdir, sess.graph)

        MSE = 0.0
        folds_count = len(X_train_folds)

        # X_train_folds[i] is the validation fold
        for i in range(folds_count):
            sess.run(tf.global_variables_initializer())
            n = 0
            # Always takes the first fold as validation fold, than move the fold to the bottom after each iteration
            print('FOLD %d' % (i + 1))
            vali_X = X_train_folds.pop(0)
            vali_y = y_train_folds.pop(0)
            best_vali_loss = 99999.0
            best_vali_acc = 0.0
            saver = tf.train.Saver()

            for i in range(start_epoch, epoch):
                # zip(X_train_folds, y_train_folds) are training folds (index = [1] & [2])
                for X_train_fold, y_train_fold in zip(X_train_folds, y_train_folds):
                    for j in range(batch):
                        batch_x = X_train_fold[j * batch_size: (j + 1) * batch_size]
                        batch_y = y_train_fold[j * batch_size: (j + 1) * batch_size]
                        sess.run(optimizer, feed_dict={X: batch_x, y: batch_y})

                iteration += 1
                result = sess.run(merged, feed_dict={X: vali_X, y: vali_y})
                writer.add_summary(result, iteration)

                vali_loss = sess.run(loss_function, feed_dict={X: vali_X, y: vali_y})
                vali_acc = sess.run(acc, feed_dict={X: vali_X, y: vali_y})

                if best_vali_acc > vali_acc:
                    n += 1
                    best_vali_loss = vali_loss if best_vali_loss > vali_loss else best_vali_loss
                    file_name = 'regular_training_epoch_%d.ckpt' % (i + 1)
                    saver.save(sess, "regular_train/%s/%s" % (training_id, file_name))
                else:
                    best_vali_loss = vali_loss if best_vali_loss > vali_loss else best_vali_loss
                    best_vali_acc = vali_acc
                    n += 0

                print("Epoch: %2d, Validation loss: %9.4f, Best loss:%9.4f, Accuracy: %.4f" %
                      (i + 1, vali_loss, best_vali_loss, vali_acc))

                if n > early_stopping:
                    print('Early Stopping at epoch %d' % i)
                    break

            MSE += (best_vali_loss ** 2) / folds_count
            X_train_folds.append(vali_X)
            y_train_folds.append(vali_y)

        file_name = 'final_model'
        save_path = saver.save(sess, "regular_train/%s/%s" % (training_id, file_name))
        print("Model saved %s" % training_id)

        test_acc = sess.run(acc, feed_dict={X: X_test1, y: y_test1})
        print("Final test accuracy: %.4f" % test_acc)

    return MSE


def DNN_testacc(epoch, n_neurons, learning_rate, activation, batch_size, early_stopping, restore_model_name=None):
    tf.reset_default_graph()

    act_str = str(activation).split()[1]
    training_id = '[n_neurons_%d, learning_rate_%f, activation_%s, batch_size_%d]' % (
        n_neurons, learning_rate, act_str, batch_size)
    print(training_id)
    training_id += "-" + datetime.utcnow().strftime("%Y%m%d%H%M%S")
    logdir = "tf_logs/{}/".format(training_id)

    X, y = init_input()
    y_hat = build_network(X, n_neurons, activation)
    loss_function, optimizer, acc = init_evaluation(y, y_hat, learning_rate)

    batch = int(mnist.train.num_examples / batch_size)

    best_vali_loss = 9999.0
    best_vali_acc = 0.0

    saver = tf.train.Saver()
    start_epoch = 0

    with tf.Session() as sess:
        if restore_model_name:
            saver.restore(sess, "regular_train/" + restore_model_name)
            start_epoch = int(restore_model_name.split('.')[0].split('_')[-1])
        else:
            sess.run(tf.global_variables_initializer())

        merged = tf.summary.merge_all()
        writer = tf.summary.FileWriter(logdir, sess.graph)

        for i in range(start_epoch, epoch):
            for j in range(batch):
                batch_x = X_train1[j * batch_size: (j + 1) * batch_size]
                batch_y = y_train1[j * batch_size: (j + 1) * batch_size]
                sess.run(optimizer, feed_dict={X: batch_x, y: batch_y})

            result = sess.run(merged, feed_dict={X: X_valid1, y: y_valid1})
            writer.add_summary(result, i + 1)

            vali_loss = sess.run(loss_function, feed_dict={X: X_valid1, y: y_valid1})
            vali_acc = sess.run(acc, feed_dict={X: X_valid1, y: y_valid1})

            if best_vali_acc < vali_acc:
                n = 0
                best_vali_acc = vali_acc
            else:
                n += 1

            if n > early_stopping:
                print('Early Stopping at epoch %d' % i)
                break

            file_name = 'regular_training_epoch_testacc_%d.ckpt' % (i + 1)
            save_path = saver.save(sess, "regular_train/%s/%s" % (training_id, file_name))

            print("Epoch: %2d, Validation loss: %9.4f, Accuracy: %.4f, Best Accuracy:%.4f" %
                  (i + 1, vali_loss, vali_acc, best_vali_acc))

        file_name = 'final_model'
        save_path = saver.save(sess, "regular_train/%s/%s" % (training_id, file_name))
        print("Model saved in path: %s" % save_path)

        test_acc = sess.run(acc, feed_dict={X: X_test1, y: y_test1})
        print("Final test accuracy: %.4f" % test_acc)


"""
neurons_list = [10, 30, 50, 70, 90, 100, 120, 140, 160]
batch_size_list = [10, 50, 100, 500]
learning_rate_list = [0.01, 0.02, 0.05, 0.1]
activation_function_list = [tf.nn.relu, tf.nn.elu, tf.nn.leaky_relu, tf.nn.tanh]
"""
params = [(160, 0.1, tf.nn.elu, 500),
          (100, 0.1, tf.nn.elu, 100),
          (10, 0.05, tf.nn.elu, 50),
          (160, 0.05, tf.nn.relu, 500),
          (100, 0.1, tf.nn.relu, 100),
          (10, 0.05, tf.nn.relu, 50),
          (160, 0.05, tf.nn.leaky_relu, 500),
          (100, 0.1, tf.nn.leaky_relu, 100),
          (10, 0.05, tf.nn.leaky_relu, 50),
          (160, 0.05, tf.nn.tanh, 500),
          (100, 0.1, tf.nn.tanh, 100),
          (10, 0.05, tf.nn.tanh, 50)]
for param in params:
    (n, lr, af, bs) = param
    MSE = DNN(epoch=1000, n_neurons=n, learning_rate=lr, activation=af, batch_size=bs, early_stopping=10)
    result[param] = MSE
test_acc = DNN_testacc(epoch=1000, n_neurons=100, learning_rate=0.1, activation=tf.nn.relu, batch_size=100, early_stopping=10)
