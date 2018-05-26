# coding: utf-8
import sys
import tensorflow as tf
old_v = tf.logging.get_verbosity()
tf.logging.set_verbosity(tf.logging.ERROR)
from tensorflow.examples.tutorials.mnist import input_data

mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)
config = tf.ConfigProto(log_device_placement=True)
config.gpu_options.allow_growth = True

input_dim = 784
output_dim = 10
_stddev = 0.1


def place_variable_on_cpu(name, shape, initializer):
    with tf.device('/cpu:0'):
        var = tf.get_variable(name, shape, initializer=initializer, dtype=tf.float32)
    return var


def build_model(x, y, h1_dim):
    def build_network(x, weights, biases):
        h1 = tf.add(tf.matmul(x, weights['h1']), biases['b1'])
        h1 = tf.nn.relu(h1)

        out_layer = tf.matmul(h1, weights['out']) + biases['out']
        out_layer = tf.nn.softmax(out_layer)
        return out_layer

    with tf.variable_scope('layer'):
        weights = {
            'h1': place_variable_on_cpu('h1', [input_dim, h1_dim], tf.random_normal_initializer(stddev=_stddev)),
            'out': place_variable_on_cpu('out_w', [h1_dim, output_dim], tf.random_normal_initializer(stddev=_stddev))
        }
        biases = {
            'b1': place_variable_on_cpu('b1', [h1_dim], tf.random_normal_initializer(stddev=_stddev)),
            'out': place_variable_on_cpu('out_b', [output_dim], tf.random_normal_initializer(stddev=_stddev))
        }

        pred = build_network(x, weights, biases)
        cost = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=pred, labels=y))
    return cost, pred


def average_gradients(tower_grads):
    average_grads = []
    for grad_and_vars in zip(*tower_grads):
        grads = []
        for g, _ in grad_and_vars:
            expanded_g = tf.expand_dims(g, 0)
            grads.append(expanded_g)
        grad = tf.concat(axis=0, values=grads)
        grad = tf.reduce_mean(grad, 0)
        v = grad_and_vars[0][1]
        grad_and_var = (grad, v)
        average_grads.append(grad_and_var)
    return average_grads


def DNN(training_steps, batch_size, learning_rate, h1_dim, gpu_num):
    with tf.Graph().as_default(), tf.device('/cpu:0'):
        x = tf.placeholder("float", [None, input_dim])
        y = tf.placeholder("float", [None, output_dim])
        tower_grads = []
        optimizer = tf.train.AdamOptimizer(learning_rate=learning_rate)

        with tf.variable_scope(tf.get_variable_scope()):
            for i in range(gpu_num):
                with tf.device('/gpu:%d' % i):
                    cost, pred = build_model(x, y, h1_dim)
                    tf.get_variable_scope().reuse_variables()
                    grads = optimizer.compute_gradients(cost)
                    tower_grads.append(grads)

        grads = average_gradients(tower_grads)
        apply_gradient_op = optimizer.apply_gradients(grads)
        train_op = apply_gradient_op

        init = tf.global_variables_initializer()
        sess = tf.Session(config=config)
        sess.run(init)

        display_step = training_steps / 10

        for step in range(training_steps):
            image_batch, label_batch = mnist.train.next_batch(batch_size)
            _, cost_print = sess.run([train_op, cost], {x: image_batch, y: label_batch})

            if step % display_step == 0:
                print("step: %04d, loss: %.4f" % (step, float(cost_print)))

        print("DONE!")

        correct_prediction = tf.equal(tf.argmax(pred, 1), tf.argmax(y, 1))
        accuracy = tf.reduce_mean(tf.cast(correct_prediction, "float"))

        with sess.as_default():
            test_acc = accuracy.eval({x: mnist.test.images, y: mnist.test.labels})

        sess.close()
        return test_acc


def main():
    if len(sys.argv) != 3:
        print('USAGE: ./MNIST_multiGPU.py [# of model] [# of GPU]')
        sys.exit()
    hp_list = []
    nums = int(sys.argv[1])
    gpu_num = int(sys.argv[2])
    for i in range(nums):
        while True:
            hp = input('For testcase %d:\n [steps] [batch size] [learning rate] [h1 dim]\n' % (i + 1))
            hp = list(map(str, hp.split()))
            if len(hp) == 4:
                break
        hp_list.append(hp)

    acc_list = []
    for i in range(nums):
        training_steps, batch_size, learning_rate, h1_dim = hp_list[i]
        training_steps = int(training_steps)
        batch_size = int(batch_size)
        learning_rate = float(learning_rate)
        h1_dim = int(h1_dim)

        test_acc = DNN(training_steps, batch_size, learning_rate, h1_dim, gpu_num)
        acc_list.append(test_acc)

    best_testcase = acc_list.index(max(acc_list))

    print("----------Test cases----------")
    print('[training_steps, batch_size, learning_rate, h1_dim] -> test_acc')
    for i in range(len(hp_list)):
        if i == best_testcase:
            print('%s -> %.4f (best model)' % (hp_list[i], acc_list[i]))
        else:
            print('%s -> %.4f' % (hp_list[i], acc_list[i]))


if __name__ == '__main__':
    main()
