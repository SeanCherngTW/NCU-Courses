# coding: utf-8

import time
import pandas as pd
import numpy as np
import sklearn.datasets
import tensorflow as tf
import matplotlib.pyplot as plt
import sklearn.model_selection as sk
from keras.utils.np_utils import to_categorical


def prepare_data(data_size=50000):
    # Read make moon data
    X, y = sklearn.datasets.make_moons(n_samples=data_size, shuffle=True, noise=0.1, random_state=None)

    # Split datasets to 80%-training / 20%-testing
    X_train, X_test, y_train, y_test = sk.train_test_split(X, y, test_size=0.2)

    # One-hot Encoding
    y_train = to_categorical(y_train, num_classes=2)
    y_test = to_categorical(y_test, num_classes=2)

    return X_train, X_test, y_train, y_test


def logistic_regression():
    tf.reset_default_graph()

    X_train, X_test, y_train, y_test = prepare_data(50000)

    # Parameters
    epoch = 20
    batch_size = 500
    learning_rate = 0.3
    nums_example = X_train.shape[0]
    total_batch = int(nums_example / batch_size)

    x = tf.placeholder('float', [None, 2], name='input_x')
    y = tf.placeholder('float', [None, 2], name='label_y')
    W = tf.Variable(tf.truncated_normal([2, 2], stddev=0.1), name="W")
    b = tf.Variable(tf.constant(0.1, shape=[1, 2]), name="b")
    y_hat = tf.nn.sigmoid(tf.matmul(x, W) + b)

    loss_function = tf.reduce_mean(-tf.reduce_sum(y * tf.log(y_hat), reduction_indices=1))
    optimizer = tf.train.GradientDescentOptimizer(learning_rate).minimize(loss_function)
    correct_prediction = tf.equal(tf.argmax(y_hat, 1), tf.argmax(y, 1))
    accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))

    iteration = 0
    sess = tf.Session()
    merged = tf.summary.merge_all()
    sess.run(tf.global_variables_initializer())

    train_acc_list = []
    test_acc_list = []

    for e in range(epoch):
        avg_cost = 0.
        avg_acc = 0.

        for i in range(total_batch):
            batch_xs, batch_ys = X_train[i * batch_size:i * batch_size + batch_size,
                                         :], y_train[i * batch_size:i * batch_size + batch_size, :]
            _, c = sess.run([optimizer, loss_function], feed_dict={x: batch_xs, y: batch_ys})
            avg_cost += c / total_batch

        train_acc = sess.run(accuracy, feed_dict={x: X_train, y: y_train})
        test_acc = sess.run(accuracy, feed_dict={x: X_test, y: y_test})

        train_acc_list.append(train_acc)
        test_acc_list.append(test_acc)

        print("Epoch: %04d, loss = %.9f, train_acc = %.4f" % ((e + 1), avg_cost, train_acc))
        print("Epoch: %04d, loss = %.9f, test_acc = %.4f" % ((e + 1), avg_cost, test_acc))
        print("-")

    print("Done!")


logistic_regression()
