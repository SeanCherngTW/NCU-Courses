# coding: utf-8

import time
import tensorflow as tf
import tensorflow.examples.tutorials.mnist.input_data as input_data
import matplotlib.pyplot as plt


def add_layer(input_dim, output_dim, inputs, name, activation_function=None):
    with tf.name_scope(name):
        with tf.name_scope('weight'):
            W = tf.Variable(tf.truncated_normal([input_dim, output_dim], stddev=0.1), name="W")
            tf.summary.histogram(name + '/weight', W)
        with tf.name_scope('bias'):
            b = tf.Variable(tf.constant(0.1, shape=[1, output_dim]), name="b")
            tf.summary.histogram(name + '/bias', b)
        with tf.name_scope('Wx_plus_b'):
            Wx_plus_b = tf.add(tf.matmul(inputs, W), b)
        if activation_function is None:
            outputs = Wx_plus_b
        else:
            outputs = activation_function(Wx_plus_b)
        tf.summary.histogram(name + '/output', outputs)
        return outputs


def mlp(restore_model_name=None):
    tf.reset_default_graph()

    # Read mnist data
    mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)

    with tf.name_scope('input'):
        # Inputs
        X = tf.placeholder('float', [None, 784], name='input_x')
        # Labels
        y = tf.placeholder('float', [None, 10], name='label_y')

    # Hidden Layer
    h1 = add_layer(input_dim=784, output_dim=1024, inputs=X, name='hidden_layer_1', activation_function=tf.nn.relu)
    # Output Layer
    y_hat = add_layer(input_dim=1024, output_dim=10, inputs=h1, name='output_layer', activation_function=tf.nn.softmax)
    with tf.name_scope('loss'):
        loss_function = -tf.reduce_sum(y * tf.log(y_hat))
        tf.summary.scalar('loss', loss_function)

    with tf.name_scope('train'):
        optimizer = tf.train.AdamOptimizer(learning_rate=0.001).minimize(loss_function)

    with tf.name_scope('accuracy'):
        with tf.name_scope('correction_prediction'):
            correct_prediction_count = tf.equal(tf.argmax(y, 1), tf.argmax(y_hat, 1))
        with tf.name_scope('accuracy'):
            acc = tf.reduce_mean(tf.cast(correct_prediction_count, 'float'))
    tf.summary.scalar('accuracy', acc)

    epoch = 10
    batch_size = 150
    batch = int(mnist.train.num_examples / batch_size)

    acc_training_list = []
    acc_validation_list = []
    acc_testing_list = []

    saver = tf.train.Saver()
    iteration = 0
    start_epoch = 0

    with tf.Session() as sess:
        if restore_model_name:
            saver.restore(sess, "regular_train/" + restore_model_name)
            start_epoch = int(restore_model_name.split('.')[0].split('_')[-1])
        else:
            sess.run(tf.global_variables_initializer())

        merged = tf.summary.merge_all()
        writer = tf.summary.FileWriter("logs/", sess.graph)
        for i in range(start_epoch, epoch):
            for _ in range(batch):
                iteration += 1
                batch_x, batch_y = mnist.train.next_batch(batch_size)
                sess.run(optimizer, feed_dict={X: batch_x, y: batch_y})
                if iteration % 50 == 0:
                    result = sess.run(merged, feed_dict={X: batch_x, y: batch_y})
                    writer.add_summary(result, iteration)

            acc_training = sess.run(acc, feed_dict={X: mnist.train.images, y: mnist.train.labels})
            acc_testing = sess.run(acc, feed_dict={X: mnist.test.images, y: mnist.test.labels})

            acc_training_list.append(acc_training)
            acc_testing_list.append(acc_testing)

            file_name = 'regular_training_epoch_%d.ckpt' % (i + 1)
            save_path = saver.save(sess, "regular_train/" + file_name)
            print("Model saved in path: %s" % save_path)

            print("Epoch: %2d, acc_training: %.4f, acc_testing: %.4f" % (i + 1, acc_training, acc_testing))


# Training
mlp()

# Restore and continue a training
mlp(restore_model_name='regular_training_epoch_6.ckpt')
