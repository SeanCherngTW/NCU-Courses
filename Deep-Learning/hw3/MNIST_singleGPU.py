# coding: utf-8
import os
import sys
import time
import math
import numpy as np
from enum import Enum
import tensorflow as tf
from datetime import datetime
from tensorflow.examples.tutorials.mnist import input_data
config = tf.ConfigProto()
config.gpu_options.allow_growth = True


def init_input():
    with tf.name_scope('input'):
        X = tf.placeholder('float', [None, 784], name='input_x')
        y = tf.placeholder('float', [None, 10], name='label_y')
    return X, y


def add_layer(input_dim, output_dim, inputs, name, he_init=False, activation_function=None):
    name_W = 'W_' + name
    name_b = 'b_' + name

    with tf.name_scope(name):
        with tf.name_scope('weight'):
            W = tf.Variable(tf.truncated_normal([input_dim, output_dim], stddev=0.1), name="W")
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


def build_network(X, af):
    h1 = add_layer(input_dim=784, output_dim=1024, inputs=X, name='hidden_layer_1', activation_function=af)
    y_hat = add_layer(input_dim=1024, output_dim=10, inputs=h1, name='output_layer', activation_function=tf.nn.softmax)
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


def DNN(epoch, learning_rate, batch_size, activation_function):
    mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)
    tf.reset_default_graph()

    af_str = str(activation_function).split()[1]
    training_id = "[epoch_{}][lr_{}][bs_{}][af_{}]".format(epoch, learning_rate, batch_size, af_str)
    print(training_id)
#     training_id += "-" + datetime.utcnow().strftime("%Y%m%d%H%M%S")
#     logdir = "tf_logs/{}/".format(training_id)

    X, y = init_input()
    y_hat = build_network(X, activation_function)
    loss_function, optimizer, acc = init_evaluation(y, y_hat, learning_rate)

    batch = int(mnist.train.num_examples / batch_size)

#     vali_loss_list = []
#     vali_acc_list = []

#     saver = tf.train.Saver()

    with tf.Session(config=config) as sess:
        sess.run(tf.global_variables_initializer())

        # merged = tf.summary.merge_all()
#         writer = tf.summary.FileWriter(logdir, sess.graph)

        best_loss = 999.9
        best_acc = 0.0

        for i in range(epoch):
            for _ in range(batch):
                batch_x, batch_y = mnist.train.next_batch(batch_size)
                sess.run(optimizer, feed_dict={X: batch_x, y: batch_y})

            # result = sess.run(merged, feed_dict={X: mnist.validation.images, y: mnist.validation.labels})

            valid_loss = sess.run(loss_function, feed_dict={X: mnist.validation.images, y: mnist.validation.labels})
            valid_acc = sess.run(acc, feed_dict={X: mnist.validation.images, y: mnist.validation.labels})

            best_loss = valid_loss if best_loss > valid_loss else best_loss
            best_acc = valid_acc if best_acc < valid_acc else best_acc

            print("Epoch: %2d, valid loss: %.4f, best loss:%.4f; valid acc: %.4f, best acc: %.4f" %
                  (i + 1, valid_loss, best_loss, valid_acc, best_acc))


#             vali_loss_list.append(vali_loss)
#             vali_acc_list.append(vali_acc)

#             writer.add_summary(result, i + 1)
#             file_name = 'regular_training_epoch_%d.ckpt' % (i+1)
#             save_path = saver.save(sess, "regular_train/%s/%s" % (training_id, file_name))

#         file_name = 'final_model'
#         save_path = saver.save(sess, "regular_train/%s/%s" %(training_id, file_name))
#         print("Model saved in path: %s" % save_path)
        test_acc = sess.run(acc, feed_dict={X: mnist.test.images, y: mnist.test.labels})
        print("Final test accuracy: %.4f" % test_acc)
        print()
        return test_acc


def main():
    if len(sys.argv) != 3:
        print('USAGE: ./MNIST_singleGPU.py [num_of_training] [gpu no.]')
        sys.exit()
    hp_list = []
    nums = int(sys.argv[1])
    gpu_no = sys.argv[2]
    for i in range(nums):
        while True:
            hp = input('For testcase %d: [epoch] [lr] [bs] [af]\n' % (i + 1))
            hp = list(map(str, hp.split()))
            if len(hp) == 4:
                break
        hp_list.append(hp)

    acc_list = []
    os.environ["CUDA_VISIBLE_DEVICES"] = gpu_no
    for i in range(nums):
        epoch, lr, bs, af = hp_list[i]
        epoch = int(epoch)
        lr = float(lr)
        bs = int(bs)
        if af == 'relu':
            af = tf.nn.relu
        elif af == 'elu':
            af = tf.nn.elu
        elif af == 'tanh':
            af = tf.nn.tanh
        test_acc = DNN(epoch, lr, bs, af)
        acc_list.append(test_acc)

    best_testcase = acc_list.index(max(acc_list))

    print("----------The best model----------")
    print("Test case = %s" % hp_list[best_testcase])
    print("Test acc  = %f" % acc_list[best_testcase])


main()
