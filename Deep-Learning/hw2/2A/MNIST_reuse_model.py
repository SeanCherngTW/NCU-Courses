# coding: utf-8

import tensorflow as tf
from keras.utils.np_utils import to_categorical
from tensorflow.examples.tutorials.mnist import input_data
mnist = input_data.read_data_sets("../MNIST_data/")
X_test1 = mnist.test.images[mnist.test.labels < 5]
y_test1 = mnist.test.labels[mnist.test.labels < 5]
y_test1 = to_categorical(y_test1, num_classes=5)
def DNN(epoch, n_neurons, learning_rate, activation, batch_size, early_stopping, keep_prob=1.0, batch_normalization=False, restore_model_name=None):        
    restore_saver = tf.train.import_meta_graph("./previous_model/final_model.ckpt.meta")
    
    # Freeze all layers except output_layer
    train_vars = tf.get_collection(tf.GraphKeys.TRAINABLE_VARIABLES, scope="output_layer")

    # For evaluation
    X = tf.get_default_graph().get_tensor_by_name("input/input_x:0")
    y = tf.get_default_graph().get_tensor_by_name("input/label_y:0")
    acc = tf.get_default_graph().get_tensor_by_name("accuracy/accuracy:0")

    # Train the output layer only
    loss = tf.get_default_graph().get_tensor_by_name("cross_entropy/cross_entropy:0")
    y_hat = tf.get_default_graph().get_tensor_by_name("output_layer/output_layer/output:0")
    optimizer = tf.train.GradientDescentOptimizer(learning_rate)
    training_op = optimizer.minimize(loss, var_list=train_vars)

    with tf.Session() as sess:
        sess.run(tf.global_variables_initializer())
        restore_saver.restore(sess, "./previous_model/final_model.ckpt")
        vali_acc = sess.run(acc, feed_dict={X: X_test1, y: y_test1})
        print("Test accuracy from restored model: %.4f" % vali_acc)
DNN(epoch=10, n_neurons=100, learning_rate=0.1, activation=tf.nn.relu, batch_size=100, early_stopping=10, keep_prob=1.00, batch_normalization=True)
