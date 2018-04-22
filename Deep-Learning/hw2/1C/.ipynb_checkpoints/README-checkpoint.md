# MNIST Cross-Validation
Find the best parameters through cross validation
```
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
```
## Output
```
--------BEST PARAMETERS--------
[n_neurons_100, learning_rate_0.100000, activation_relu, batch_size_100]
Epoch:  1, Validation loss:    0.9462, Accuracy: 0.9629, Best Accuracy:0.9629
Epoch:  2, Validation loss:    0.9386, Accuracy: 0.9672, Best Accuracy:0.9672
Epoch:  3, Validation loss:    0.9347, Accuracy: 0.9722, Best Accuracy:0.9722
Epoch:  4, Validation loss:    0.9324, Accuracy: 0.9738, Best Accuracy:0.9738
Epoch:  5, Validation loss:    0.9286, Accuracy: 0.9769, Best Accuracy:0.9769
Epoch:  6, Validation loss:    0.9274, Accuracy: 0.9781, Best Accuracy:0.9781
Epoch:  7, Validation loss:    0.9272, Accuracy: 0.9765, Best Accuracy:0.9781
Epoch:  8, Validation loss:    0.9258, Accuracy: 0.9789, Best Accuracy:0.9789
Epoch:  9, Validation loss:    0.9254, Accuracy: 0.9793, Best Accuracy:0.9793
Epoch: 10, Validation loss:    0.9246, Accuracy: 0.9797, Best Accuracy:0.9797
Epoch: 11, Validation loss:    0.9234, Accuracy: 0.9816, Best Accuracy:0.9816
Epoch: 12, Validation loss:    0.9236, Accuracy: 0.9812, Best Accuracy:0.9816
Epoch: 13, Validation loss:    0.9229, Accuracy: 0.9828, Best Accuracy:0.9828
Epoch: 14, Validation loss:    0.9229, Accuracy: 0.9824, Best Accuracy:0.9828
Epoch: 15, Validation loss:    0.9226, Accuracy: 0.9828, Best Accuracy:0.9828
Epoch: 16, Validation loss:    0.9221, Accuracy: 0.9828, Best Accuracy:0.9828
Epoch: 17, Validation loss:    0.9218, Accuracy: 0.9828, Best Accuracy:0.9828
Epoch: 18, Validation loss:    0.9227, Accuracy: 0.9820, Best Accuracy:0.9828
Epoch: 19, Validation loss:    0.9217, Accuracy: 0.9828, Best Accuracy:0.9828
Epoch: 20, Validation loss:    0.9212, Accuracy: 0.9844, Best Accuracy:0.9844
Epoch: 21, Validation loss:    0.9212, Accuracy: 0.9844, Best Accuracy:0.9844
Epoch: 22, Validation loss:    0.9210, Accuracy: 0.9840, Best Accuracy:0.9844
Epoch: 23, Validation loss:    0.9203, Accuracy: 0.9851, Best Accuracy:0.9851
Epoch: 24, Validation loss:    0.9203, Accuracy: 0.9851, Best Accuracy:0.9851
Epoch: 25, Validation loss:    0.9202, Accuracy: 0.9844, Best Accuracy:0.9851
Epoch: 26, Validation loss:    0.9199, Accuracy: 0.9844, Best Accuracy:0.9851
Epoch: 27, Validation loss:    0.9199, Accuracy: 0.9848, Best Accuracy:0.9851
Epoch: 28, Validation loss:    0.9199, Accuracy: 0.9851, Best Accuracy:0.9851
Epoch: 29, Validation loss:    0.9198, Accuracy: 0.9851, Best Accuracy:0.9851
Epoch: 30, Validation loss:    0.9197, Accuracy: 0.9851, Best Accuracy:0.9851
Epoch: 31, Validation loss:    0.9196, Accuracy: 0.9859, Best Accuracy:0.9859
Epoch: 32, Validation loss:    0.9196, Accuracy: 0.9859, Best Accuracy:0.9859
Epoch: 33, Validation loss:    0.9197, Accuracy: 0.9848, Best Accuracy:0.9859
Epoch: 34, Validation loss:    0.9197, Accuracy: 0.9848, Best Accuracy:0.9859
Epoch: 35, Validation loss:    0.9197, Accuracy: 0.9848, Best Accuracy:0.9859
Epoch: 36, Validation loss:    0.9197, Accuracy: 0.9851, Best Accuracy:0.9859
Epoch: 37, Validation loss:    0.9195, Accuracy: 0.9840, Best Accuracy:0.9859
Epoch: 38, Validation loss:    0.9195, Accuracy: 0.9844, Best Accuracy:0.9859
Epoch: 39, Validation loss:    0.9195, Accuracy: 0.9844, Best Accuracy:0.9859
Epoch: 40, Validation loss:    0.9193, Accuracy: 0.9848, Best Accuracy:0.9859
Epoch: 41, Validation loss:    0.9188, Accuracy: 0.9863, Best Accuracy:0.9863
Epoch: 42, Validation loss:    0.9196, Accuracy: 0.9848, Best Accuracy:0.9863
Epoch: 43, Validation loss:    0.9195, Accuracy: 0.9851, Best Accuracy:0.9863
Epoch: 44, Validation loss:    0.9187, Accuracy: 0.9859, Best Accuracy:0.9863
Epoch: 45, Validation loss:    0.9188, Accuracy: 0.9855, Best Accuracy:0.9863
Epoch: 46, Validation loss:    0.9186, Accuracy: 0.9859, Best Accuracy:0.9863
Epoch: 47, Validation loss:    0.9186, Accuracy: 0.9851, Best Accuracy:0.9863
Epoch: 48, Validation loss:    0.9187, Accuracy: 0.9855, Best Accuracy:0.9863
Epoch: 49, Validation loss:    0.9188, Accuracy: 0.9863, Best Accuracy:0.9863
Epoch: 50, Validation loss:    0.9188, Accuracy: 0.9848, Best Accuracy:0.9863
Epoch: 51, Validation loss:    0.9182, Accuracy: 0.9871, Best Accuracy:0.9871
Epoch: 52, Validation loss:    0.9204, Accuracy: 0.9836, Best Accuracy:0.9871
Epoch: 53, Validation loss:    0.9182, Accuracy: 0.9867, Best Accuracy:0.9871
Epoch: 54, Validation loss:    0.9183, Accuracy: 0.9863, Best Accuracy:0.9871
Epoch: 55, Validation loss:    0.9182, Accuracy: 0.9867, Best Accuracy:0.9871
Epoch: 56, Validation loss:    0.9180, Accuracy: 0.9867, Best Accuracy:0.9871
Epoch: 57, Validation loss:    0.9179, Accuracy: 0.9875, Best Accuracy:0.9875
Epoch: 58, Validation loss:    0.9181, Accuracy: 0.9867, Best Accuracy:0.9875
Epoch: 59, Validation loss:    0.9184, Accuracy: 0.9863, Best Accuracy:0.9875
Epoch: 60, Validation loss:    0.9181, Accuracy: 0.9859, Best Accuracy:0.9875
Epoch: 61, Validation loss:    0.9181, Accuracy: 0.9859, Best Accuracy:0.9875
Epoch: 62, Validation loss:    0.9179, Accuracy: 0.9863, Best Accuracy:0.9875
Epoch: 63, Validation loss:    0.9178, Accuracy: 0.9875, Best Accuracy:0.9875
Epoch: 64, Validation loss:    0.9179, Accuracy: 0.9871, Best Accuracy:0.9875
Epoch: 65, Validation loss:    0.9177, Accuracy: 0.9875, Best Accuracy:0.9875
Epoch: 66, Validation loss:    0.9176, Accuracy: 0.9871, Best Accuracy:0.9875
Epoch: 67, Validation loss:    0.9178, Accuracy: 0.9871, Best Accuracy:0.9875
Early Stopping at epoch 67
Model saved in path: regular_train/[n_neurons_100, learning_rate_0.100000, activation_relu, batch_size_100]-20180422025057/final_model
Final test accuracy: 0.9905
```