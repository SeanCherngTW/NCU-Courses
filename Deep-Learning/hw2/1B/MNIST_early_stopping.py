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
            #             W = tf.Variable(tf.truncated_normal([input_dim, output_dim], stddev=0.1), name="W")
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


def build_network(X):
    h1 = add_layer(input_dim=784, output_dim=100, inputs=X, name='hidden_layer_1', activation_function=tf.nn.elu)
    h2 = add_layer(input_dim=100, output_dim=100, inputs=h1, name='hidden_layer_2', activation_function=tf.nn.elu)
    h3 = add_layer(input_dim=100, output_dim=100, inputs=h2, name='hidden_layer_3', activation_function=tf.nn.elu)
    h4 = add_layer(input_dim=100, output_dim=100, inputs=h3, name='hidden_layer_4', activation_function=tf.nn.elu)
    h5 = add_layer(input_dim=100, output_dim=100, inputs=h4, name='hidden_layer_5', activation_function=tf.nn.elu)
    y_hat = add_layer(input_dim=100, output_dim=5, inputs=h5, name='output_layer', activation_function=tf.nn.softmax)
    return y_hat


def init_evaluation(y, y_hat, learning_rate):
    with tf.name_scope('cross_entropy'):
        loss_function = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(labels=y, logits=y_hat))
    tf.summary.scalar('cross_entropy', loss_function)

    with tf.name_scope('train'):
        optimizer = tf.train.AdamOptimizer(learning_rate=learning_rate).minimize(loss_function)

    with tf.name_scope('accuracy'):
        with tf.name_scope('correction_prediction'):
            correct_prediction_count = tf.equal(tf.argmax(y, 1), tf.argmax(y_hat, 1))
        with tf.name_scope('accuracy'):
            acc = tf.reduce_mean(tf.cast(correct_prediction_count, 'float'))
    tf.summary.scalar('accuracy', acc)

    return loss_function, optimizer, acc


def DNN(epoch, learning_rate, batch_size, early_stopping, restore_model_name=None):
    tf.reset_default_graph()

    training_id = "[epoch_{}][lr_{}][bs_{}]".format(epoch, learning_rate, batch_size)
    training_id += "-" + datetime.utcnow().strftime("%Y%m%d%H%M%S")
    logdir = "tf_logs/{}/".format(training_id)

    X, y = init_input()
    y_hat = build_network(X)
    loss_function, optimizer, acc = init_evaluation(y, y_hat, learning_rate)

    batch = int(mnist.train.num_examples / batch_size)

    vali_loss_list = []
    vali_acc_list = []
    n = 0

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

            vali_loss_list.append(vali_loss)
            vali_acc_list.append(vali_acc)

            file_name = 'regular_training_epoch_%d.ckpt' % (i + 1)
            save_path = saver.save(sess, "regular_train/%s/%s" % (training_id, file_name))
            best_vali_acc = max(vali_acc_list)
            best_vali_loss = min(vali_loss_list)

            print("Epoch: %2d, Validation loss: %9.4f, Best loss:%9.4f, Accuracy: %.4f, Best Accuracy: %.4f" %
                  (i + 1, vali_loss, best_vali_loss, vali_acc, best_vali_acc))

            if vali_acc < best_vali_acc:
                #                 print('Early stopping %d' % n)
                n += 1
            else:
                n = 0

            if n > early_stopping:
                print('Early Stopping at epoch %d' % i)
                break

        file_name = 'final_model'
        save_path = saver.save(sess, "regular_train/%s/%s" % (training_id, file_name))
        print("Model saved in path: %s" % save_path)

        test_acc = sess.run(acc, feed_dict={X: X_test1, y: y_test1})
        print("Final test accuracy: %.4f" % test_acc)


DNN(epoch=1000, learning_rate=0.0006, batch_size=400, early_stopping=10)
