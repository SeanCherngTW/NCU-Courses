# MNIST Batch Normalization
## Summary
```
Test Acc
Without Batch Normalization: 0.3826
With Batch Normalization: 0.9914
```
## Output
```
[n_neurons_100, learning_rate_0.0040, activation_<function elu at 0x10c49a378>, batch_size_400, batch_normalization_False]
Epoch:  1, Validation loss:    1.2443, Best loss:   1.2443, Accuracy: 0.6579, Best Accuracy: 0.6579
Epoch:  2, Validation loss:    1.0172, Best loss:   1.0172, Accuracy: 0.8858, Best Accuracy: 0.8858
Epoch:  3, Validation loss:    1.0666, Best loss:   1.0172, Accuracy: 0.8378, Best Accuracy: 0.8858
Epoch:  4, Validation loss:    1.0021, Best loss:   1.0021, Accuracy: 0.9027, Best Accuracy: 0.9027
Epoch:  5, Validation loss:    1.0112, Best loss:   1.0021, Accuracy: 0.8937, Best Accuracy: 0.9027
Epoch:  6, Validation loss:    0.9665, Best loss:   0.9665, Accuracy: 0.9382, Best Accuracy: 0.9382
Epoch:  7, Validation loss:    1.0542, Best loss:   0.9665, Accuracy: 0.8507, Best Accuracy: 0.9382
Epoch:  8, Validation loss:    1.0123, Best loss:   0.9665, Accuracy: 0.8925, Best Accuracy: 0.9382
Epoch:  9, Validation loss:    1.0053, Best loss:   0.9665, Accuracy: 0.8995, Best Accuracy: 0.9382
Epoch: 10, Validation loss:    1.2891, Best loss:   0.9665, Accuracy: 0.6157, Best Accuracy: 0.9382
Epoch: 11, Validation loss:    1.2066, Best loss:   0.9665, Accuracy: 0.6982, Best Accuracy: 0.9382
Epoch: 12, Validation loss:    1.1762, Best loss:   0.9665, Accuracy: 0.7287, Best Accuracy: 0.9382
Epoch: 13, Validation loss:    1.3888, Best loss:   0.9665, Accuracy: 0.5160, Best Accuracy: 0.9382
Epoch: 14, Validation loss:    1.3423, Best loss:   0.9665, Accuracy: 0.5625, Best Accuracy: 0.9382
Epoch: 15, Validation loss:    1.3399, Best loss:   0.9665, Accuracy: 0.5649, Best Accuracy: 0.9382
Epoch: 16, Validation loss:    1.3360, Best loss:   0.9665, Accuracy: 0.5688, Best Accuracy: 0.9382
Epoch: 17, Validation loss:    1.3360, Best loss:   0.9665, Accuracy: 0.5688, Best Accuracy: 0.9382
Epoch: 18, Validation loss:    1.4986, Best loss:   0.9665, Accuracy: 0.4062, Best Accuracy: 0.9382
Epoch: 19, Validation loss:    1.3935, Best loss:   0.9665, Accuracy: 0.5113, Best Accuracy: 0.9382
Epoch: 20, Validation loss:    1.3298, Best loss:   0.9665, Accuracy: 0.5751, Best Accuracy: 0.9382
Epoch: 21, Validation loss:    1.1793, Best loss:   0.9665, Accuracy: 0.7256, Best Accuracy: 0.9382
Epoch: 22, Validation loss:    1.1656, Best loss:   0.9665, Accuracy: 0.7392, Best Accuracy: 0.9382
Epoch: 23, Validation loss:    1.1625, Best loss:   0.9665, Accuracy: 0.7424, Best Accuracy: 0.9382
Epoch: 24, Validation loss:    1.1625, Best loss:   0.9665, Accuracy: 0.7424, Best Accuracy: 0.9382
Epoch: 25, Validation loss:    1.1640, Best loss:   0.9665, Accuracy: 0.7408, Best Accuracy: 0.9382
Epoch: 26, Validation loss:    1.1648, Best loss:   0.9665, Accuracy: 0.7400, Best Accuracy: 0.9382
Epoch: 27, Validation loss:    1.4060, Best loss:   0.9665, Accuracy: 0.4988, Best Accuracy: 0.9382
Epoch: 28, Validation loss:    1.4541, Best loss:   0.9665, Accuracy: 0.4507, Best Accuracy: 0.9382
Epoch: 29, Validation loss:    1.4349, Best loss:   0.9665, Accuracy: 0.4699, Best Accuracy: 0.9382
Epoch: 30, Validation loss:    1.6324, Best loss:   0.9665, Accuracy: 0.2725, Best Accuracy: 0.9382
Epoch: 31, Validation loss:    1.5311, Best loss:   0.9665, Accuracy: 0.3737, Best Accuracy: 0.9382
Epoch: 32, Validation loss:    1.5311, Best loss:   0.9665, Accuracy: 0.3737, Best Accuracy: 0.9382
Epoch: 33, Validation loss:    1.5311, Best loss:   0.9665, Accuracy: 0.3737, Best Accuracy: 0.9382
Epoch: 34, Validation loss:    1.5311, Best loss:   0.9665, Accuracy: 0.3737, Best Accuracy: 0.9382
Epoch: 35, Validation loss:    1.5311, Best loss:   0.9665, Accuracy: 0.3737, Best Accuracy: 0.9382
Epoch: 36, Validation loss:    1.5311, Best loss:   0.9665, Accuracy: 0.3737, Best Accuracy: 0.9382
Epoch: 37, Validation loss:    1.5311, Best loss:   0.9665, Accuracy: 0.3737, Best Accuracy: 0.9382
Early Stopping at epoch 37
Model saved in path: regular_train/[n_neurons_100, learning_rate_0.0040, activation_<function elu at 0x10c49a378>, batch_size_400, batch_normalization_False]-20180422083509/final_model
Final test accuracy: 0.3826
[n_neurons_100, learning_rate_0.0040, activation_<function elu at 0x10c49a378>, batch_size_400, batch_normalization_True]
Epoch:  1, Validation loss:    0.9663, Best loss:   0.9663, Accuracy: 0.9418, Best Accuracy: 0.9418
Epoch:  2, Validation loss:    0.9287, Best loss:   0.9287, Accuracy: 0.9762, Best Accuracy: 0.9762
Epoch:  3, Validation loss:    0.9369, Best loss:   0.9287, Accuracy: 0.9683, Best Accuracy: 0.9762
Epoch:  4, Validation loss:    0.9406, Best loss:   0.9287, Accuracy: 0.9652, Best Accuracy: 0.9762
Epoch:  5, Validation loss:    0.9343, Best loss:   0.9287, Accuracy: 0.9719, Best Accuracy: 0.9762
Epoch:  6, Validation loss:    0.9240, Best loss:   0.9240, Accuracy: 0.9805, Best Accuracy: 0.9805
Epoch:  7, Validation loss:    0.9314, Best loss:   0.9240, Accuracy: 0.9730, Best Accuracy: 0.9805
Epoch:  8, Validation loss:    0.9252, Best loss:   0.9240, Accuracy: 0.9797, Best Accuracy: 0.9805
Epoch:  9, Validation loss:    0.9430, Best loss:   0.9240, Accuracy: 0.9609, Best Accuracy: 0.9805
Epoch: 10, Validation loss:    0.9193, Best loss:   0.9193, Accuracy: 0.9859, Best Accuracy: 0.9859
Epoch: 11, Validation loss:    0.9249, Best loss:   0.9193, Accuracy: 0.9793, Best Accuracy: 0.9859
Epoch: 12, Validation loss:    0.9337, Best loss:   0.9193, Accuracy: 0.9695, Best Accuracy: 0.9859
Epoch: 13, Validation loss:    0.9218, Best loss:   0.9193, Accuracy: 0.9828, Best Accuracy: 0.9859
Epoch: 14, Validation loss:    0.9209, Best loss:   0.9193, Accuracy: 0.9840, Best Accuracy: 0.9859
Epoch: 15, Validation loss:    0.9192, Best loss:   0.9192, Accuracy: 0.9863, Best Accuracy: 0.9863
Epoch: 16, Validation loss:    0.9253, Best loss:   0.9192, Accuracy: 0.9797, Best Accuracy: 0.9863
Epoch: 17, Validation loss:    0.9217, Best loss:   0.9192, Accuracy: 0.9832, Best Accuracy: 0.9863
Epoch: 18, Validation loss:    0.9239, Best loss:   0.9192, Accuracy: 0.9805, Best Accuracy: 0.9863
Epoch: 19, Validation loss:    0.9177, Best loss:   0.9177, Accuracy: 0.9867, Best Accuracy: 0.9867
Epoch: 20, Validation loss:    0.9226, Best loss:   0.9177, Accuracy: 0.9820, Best Accuracy: 0.9867
Epoch: 21, Validation loss:    0.9164, Best loss:   0.9164, Accuracy: 0.9879, Best Accuracy: 0.9879
Epoch: 22, Validation loss:    0.9190, Best loss:   0.9164, Accuracy: 0.9851, Best Accuracy: 0.9879
Epoch: 23, Validation loss:    0.9180, Best loss:   0.9164, Accuracy: 0.9863, Best Accuracy: 0.9879
Epoch: 24, Validation loss:    0.9171, Best loss:   0.9164, Accuracy: 0.9867, Best Accuracy: 0.9879
Epoch: 25, Validation loss:    0.9118, Best loss:   0.9118, Accuracy: 0.9922, Best Accuracy: 0.9922
Epoch: 26, Validation loss:    0.9149, Best loss:   0.9118, Accuracy: 0.9902, Best Accuracy: 0.9922
Epoch: 27, Validation loss:    0.9151, Best loss:   0.9118, Accuracy: 0.9894, Best Accuracy: 0.9922
Epoch: 28, Validation loss:    0.9173, Best loss:   0.9118, Accuracy: 0.9875, Best Accuracy: 0.9922
Epoch: 29, Validation loss:    0.9156, Best loss:   0.9118, Accuracy: 0.9891, Best Accuracy: 0.9922
Epoch: 30, Validation loss:    0.9216, Best loss:   0.9118, Accuracy: 0.9832, Best Accuracy: 0.9922
Epoch: 31, Validation loss:    0.9249, Best loss:   0.9118, Accuracy: 0.9793, Best Accuracy: 0.9922
Epoch: 32, Validation loss:    0.9226, Best loss:   0.9118, Accuracy: 0.9820, Best Accuracy: 0.9922
Epoch: 33, Validation loss:    0.9157, Best loss:   0.9118, Accuracy: 0.9887, Best Accuracy: 0.9922
Epoch: 34, Validation loss:    0.9137, Best loss:   0.9118, Accuracy: 0.9914, Best Accuracy: 0.9922
Epoch: 35, Validation loss:    0.9174, Best loss:   0.9118, Accuracy: 0.9871, Best Accuracy: 0.9922
Epoch: 36, Validation loss:    0.9147, Best loss:   0.9118, Accuracy: 0.9902, Best Accuracy: 0.9922
Early Stopping at epoch 36
Model saved in path: regular_train/[n_neurons_100, learning_rate_0.0040, activation_<function elu at 0x10c49a378>, batch_size_400, batch_normalization_True]-20180422083535/final_model
Final test accuracy: 0.9914
```