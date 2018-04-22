# MNIST Dropout
## Summary
```
keep_prob: 1.00 -> train_acc = 0.9970, test_acc = 0.9912
keep_prob: 0.95 -> train_acc = 0.9919, test_acc = 0.9887
```

## Output
```
[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11310b6a8>, batch_size_100, keep_prob_1.0]
Epoch:  1, Train acc: 0.9800, Validation acc: 0.9742
Epoch:  2, Train acc: 0.9864, Validation acc: 0.9805
Epoch:  3, Train acc: 0.9891, Validation acc: 0.9848
Epoch:  4, Train acc: 0.9910, Validation acc: 0.9859
Epoch:  5, Train acc: 0.9919, Validation acc: 0.9875
Epoch:  6, Train acc: 0.9930, Validation acc: 0.9875
Epoch:  7, Train acc: 0.9935, Validation acc: 0.9883
Epoch:  8, Train acc: 0.9944, Validation acc: 0.9879
Epoch:  9, Train acc: 0.9946, Validation acc: 0.9863
Epoch: 10, Train acc: 0.9952, Validation acc: 0.9887
Epoch: 11, Train acc: 0.9956, Validation acc: 0.9871
Epoch: 12, Train acc: 0.9961, Validation acc: 0.9875
Epoch: 13, Train acc: 0.9961, Validation acc: 0.9879
Epoch: 14, Train acc: 0.9965, Validation acc: 0.9883
Epoch: 15, Train acc: 0.9965, Validation acc: 0.9879
Epoch: 16, Train acc: 0.9968, Validation acc: 0.9879
Epoch: 17, Train acc: 0.9968, Validation acc: 0.9879
Epoch: 18, Train acc: 0.9969, Validation acc: 0.9879
Epoch: 19, Train acc: 0.9970, Validation acc: 0.9879
Epoch: 20, Train acc: 0.9970, Validation acc: 0.9879
Epoch: 21, Train acc: 0.9970, Validation acc: 0.9879
Early Stopping at epoch 21
Model saved in path: regular_train/[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11310b6a8>, batch_size_100, keep_prob_1.0]-20180422074825/final_model
Final: Train acc: 0.9970, Test acc: 0.9912, Difference: 0.0058
```
```
[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11310b6a8>, batch_size_100, keep_prob_0.95]
Epoch:  1, Train acc: 0.9536, Validation acc: 0.9582
Epoch:  2, Train acc: 0.9654, Validation acc: 0.9648
Epoch:  3, Train acc: 0.9731, Validation acc: 0.9722
Epoch:  4, Train acc: 0.9755, Validation acc: 0.9711
Epoch:  5, Train acc: 0.9783, Validation acc: 0.9750
Epoch:  6, Train acc: 0.9806, Validation acc: 0.9765
Epoch:  7, Train acc: 0.9805, Validation acc: 0.9805
Epoch:  8, Train acc: 0.9828, Validation acc: 0.9797
Epoch:  9, Train acc: 0.9841, Validation acc: 0.9785
Epoch: 10, Train acc: 0.9847, Validation acc: 0.9816
Epoch: 11, Train acc: 0.9857, Validation acc: 0.9789
Epoch: 12, Train acc: 0.9846, Validation acc: 0.9812
Epoch: 13, Train acc: 0.9863, Validation acc: 0.9816
Epoch: 14, Train acc: 0.9867, Validation acc: 0.9789
Epoch: 15, Train acc: 0.9862, Validation acc: 0.9820
Epoch: 16, Train acc: 0.9865, Validation acc: 0.9828
Epoch: 17, Train acc: 0.9876, Validation acc: 0.9789
Epoch: 18, Train acc: 0.9874, Validation acc: 0.9789
Epoch: 19, Train acc: 0.9883, Validation acc: 0.9801
Epoch: 20, Train acc: 0.9882, Validation acc: 0.9797
Epoch: 21, Train acc: 0.9900, Validation acc: 0.9816
Epoch: 22, Train acc: 0.9893, Validation acc: 0.9816
Epoch: 23, Train acc: 0.9898, Validation acc: 0.9808
Epoch: 24, Train acc: 0.9907, Validation acc: 0.9816
Epoch: 25, Train acc: 0.9893, Validation acc: 0.9836
Epoch: 26, Train acc: 0.9893, Validation acc: 0.9805
Epoch: 27, Train acc: 0.9907, Validation acc: 0.9820
Epoch: 28, Train acc: 0.9902, Validation acc: 0.9816
Epoch: 29, Train acc: 0.9900, Validation acc: 0.9812
Epoch: 30, Train acc: 0.9893, Validation acc: 0.9832
Epoch: 31, Train acc: 0.9900, Validation acc: 0.9812
Epoch: 32, Train acc: 0.9906, Validation acc: 0.9797
Epoch: 33, Train acc: 0.9911, Validation acc: 0.9848
Epoch: 34, Train acc: 0.9909, Validation acc: 0.9832
Epoch: 35, Train acc: 0.9905, Validation acc: 0.9859
Epoch: 36, Train acc: 0.9913, Validation acc: 0.9844
Epoch: 37, Train acc: 0.9914, Validation acc: 0.9836
Epoch: 38, Train acc: 0.9912, Validation acc: 0.9859
Epoch: 39, Train acc: 0.9910, Validation acc: 0.9824
Epoch: 40, Train acc: 0.9912, Validation acc: 0.9832
Epoch: 41, Train acc: 0.9913, Validation acc: 0.9828
Epoch: 42, Train acc: 0.9911, Validation acc: 0.9859
Epoch: 43, Train acc: 0.9913, Validation acc: 0.9871
Epoch: 44, Train acc: 0.9913, Validation acc: 0.9836
Epoch: 45, Train acc: 0.9910, Validation acc: 0.9844
Epoch: 46, Train acc: 0.9916, Validation acc: 0.9844
Epoch: 47, Train acc: 0.9913, Validation acc: 0.9840
Epoch: 48, Train acc: 0.9919, Validation acc: 0.9840
Epoch: 49, Train acc: 0.9918, Validation acc: 0.9836
Epoch: 50, Train acc: 0.9898, Validation acc: 0.9855
Epoch: 51, Train acc: 0.9910, Validation acc: 0.9875
Epoch: 52, Train acc: 0.9914, Validation acc: 0.9867
Epoch: 53, Train acc: 0.9918, Validation acc: 0.9859
Epoch: 54, Train acc: 0.9920, Validation acc: 0.9840
Epoch: 55, Train acc: 0.9925, Validation acc: 0.9828
Epoch: 56, Train acc: 0.9926, Validation acc: 0.9859
Epoch: 57, Train acc: 0.9915, Validation acc: 0.9855
Epoch: 58, Train acc: 0.9922, Validation acc: 0.9867
Epoch: 59, Train acc: 0.9922, Validation acc: 0.9851
Epoch: 60, Train acc: 0.9923, Validation acc: 0.9859
Epoch: 61, Train acc: 0.9920, Validation acc: 0.9824
Epoch: 62, Train acc: 0.9924, Validation acc: 0.9855
Early Stopping at epoch 62
Model saved in path: regular_train/[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11310b6a8>, batch_size_100, keep_prob_0.95]-20180422075432/final_model
Final: Train acc: 0.9919, Test acc: 0.9887, Difference: 0.0032
```