# MNIST Dropout
## Summary
keep_prob: 1.0 -> train_acc = 0.9972, test_acc = 0.9905
keep_prob: 0.9 -> train_acc = 0.9948, test_acc = 0.9909
keep_prob: 0.7 -> train_acc = 0.9877, test_acc = 0.9862

## Output
[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11533c6a8>, batch_size_100, keep_prob_1.0]
Epoch:  1, Train acc: 0.9794, Validation acc: 0.9738
Epoch:  2, Train acc: 0.9865, Validation acc: 0.9820
Epoch:  3, Train acc: 0.9892, Validation acc: 0.9828
Epoch:  4, Train acc: 0.9913, Validation acc: 0.9824
Epoch:  5, Train acc: 0.9924, Validation acc: 0.9844
Epoch:  6, Train acc: 0.9936, Validation acc: 0.9844
Epoch:  7, Train acc: 0.9942, Validation acc: 0.9851
Epoch:  8, Train acc: 0.9949, Validation acc: 0.9855
Epoch:  9, Train acc: 0.9951, Validation acc: 0.9851
Epoch: 10, Train acc: 0.9956, Validation acc: 0.9867
Epoch: 11, Train acc: 0.9957, Validation acc: 0.9867
Epoch: 12, Train acc: 0.9960, Validation acc: 0.9863
Epoch: 13, Train acc: 0.9962, Validation acc: 0.9867
Epoch: 14, Train acc: 0.9961, Validation acc: 0.9871
Epoch: 15, Train acc: 0.9964, Validation acc: 0.9883
Epoch: 16, Train acc: 0.9965, Validation acc: 0.9875
Epoch: 17, Train acc: 0.9966, Validation acc: 0.9871
Epoch: 18, Train acc: 0.9967, Validation acc: 0.9879
Epoch: 19, Train acc: 0.9968, Validation acc: 0.9875
Epoch: 20, Train acc: 0.9968, Validation acc: 0.9875
Epoch: 21, Train acc: 0.9968, Validation acc: 0.9875
Epoch: 22, Train acc: 0.9969, Validation acc: 0.9871
Epoch: 23, Train acc: 0.9969, Validation acc: 0.9871
Epoch: 24, Train acc: 0.9970, Validation acc: 0.9871
Epoch: 25, Train acc: 0.9971, Validation acc: 0.9871
Epoch: 26, Train acc: 0.9972, Validation acc: 0.9875
Early Stopping at epoch 25
Model saved in path: regular_train/[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11533c6a8>, batch_size_100, keep_prob_1.0]-20180421041759/final_model
Final: Train acc: 0.9972, Test acc: 0.9905, Difference: 0.0067
[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11533c6a8>, batch_size_100, keep_prob_0.9]
Epoch:  1, Train acc: 0.9624, Validation acc: 0.9617
Epoch:  2, Train acc: 0.9728, Validation acc: 0.9711
Epoch:  3, Train acc: 0.9781, Validation acc: 0.9746
Epoch:  4, Train acc: 0.9808, Validation acc: 0.9758
Epoch:  5, Train acc: 0.9826, Validation acc: 0.9773
Epoch:  6, Train acc: 0.9840, Validation acc: 0.9785
Epoch:  7, Train acc: 0.9857, Validation acc: 0.9812
Epoch:  8, Train acc: 0.9862, Validation acc: 0.9855
Epoch:  9, Train acc: 0.9877, Validation acc: 0.9816
Epoch: 10, Train acc: 0.9888, Validation acc: 0.9812
Epoch: 11, Train acc: 0.9889, Validation acc: 0.9855
Epoch: 12, Train acc: 0.9889, Validation acc: 0.9836
Epoch: 13, Train acc: 0.9903, Validation acc: 0.9855
Epoch: 14, Train acc: 0.9912, Validation acc: 0.9812
Epoch: 15, Train acc: 0.9908, Validation acc: 0.9851
Epoch: 16, Train acc: 0.9918, Validation acc: 0.9883
Epoch: 17, Train acc: 0.9925, Validation acc: 0.9855
Epoch: 18, Train acc: 0.9933, Validation acc: 0.9867
Epoch: 19, Train acc: 0.9929, Validation acc: 0.9887
Epoch: 20, Train acc: 0.9931, Validation acc: 0.9851
Epoch: 21, Train acc: 0.9933, Validation acc: 0.9859
Epoch: 22, Train acc: 0.9938, Validation acc: 0.9855
Epoch: 23, Train acc: 0.9938, Validation acc: 0.9875
Epoch: 24, Train acc: 0.9937, Validation acc: 0.9851
Epoch: 25, Train acc: 0.9934, Validation acc: 0.9851
Epoch: 26, Train acc: 0.9944, Validation acc: 0.9875
Epoch: 27, Train acc: 0.9947, Validation acc: 0.9848
Epoch: 28, Train acc: 0.9950, Validation acc: 0.9879
Epoch: 29, Train acc: 0.9948, Validation acc: 0.9867
Epoch: 30, Train acc: 0.9950, Validation acc: 0.9883
Early Stopping at epoch 29
Model saved in path: regular_train/[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11533c6a8>, batch_size_100, keep_prob_0.9]-20180421041920/final_model
Final: Train acc: 0.9948, Test acc: 0.9909, Difference: 0.0040
[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11533c6a8>, batch_size_100, keep_prob_0.7]
Epoch:  1, Train acc: 0.9267, Validation acc: 0.9249
Epoch:  2, Train acc: 0.9502, Validation acc: 0.9547
Epoch:  3, Train acc: 0.9610, Validation acc: 0.9597
Epoch:  4, Train acc: 0.9660, Validation acc: 0.9656
Epoch:  5, Train acc: 0.9680, Validation acc: 0.9683
Epoch:  6, Train acc: 0.9717, Validation acc: 0.9691
Epoch:  7, Train acc: 0.9720, Validation acc: 0.9703
Epoch:  8, Train acc: 0.9746, Validation acc: 0.9722
Epoch:  9, Train acc: 0.9761, Validation acc: 0.9742
Epoch: 10, Train acc: 0.9776, Validation acc: 0.9742
Epoch: 11, Train acc: 0.9795, Validation acc: 0.9734
Epoch: 12, Train acc: 0.9801, Validation acc: 0.9781
Epoch: 13, Train acc: 0.9797, Validation acc: 0.9777
Epoch: 14, Train acc: 0.9803, Validation acc: 0.9789
Epoch: 15, Train acc: 0.9816, Validation acc: 0.9805
Epoch: 16, Train acc: 0.9825, Validation acc: 0.9777
Epoch: 17, Train acc: 0.9830, Validation acc: 0.9781
Epoch: 18, Train acc: 0.9840, Validation acc: 0.9816
Epoch: 19, Train acc: 0.9833, Validation acc: 0.9785
Epoch: 20, Train acc: 0.9842, Validation acc: 0.9812
Epoch: 21, Train acc: 0.9852, Validation acc: 0.9824
Epoch: 22, Train acc: 0.9848, Validation acc: 0.9816
Epoch: 23, Train acc: 0.9861, Validation acc: 0.9855
Epoch: 24, Train acc: 0.9852, Validation acc: 0.9836
Epoch: 25, Train acc: 0.9864, Validation acc: 0.9797
Epoch: 26, Train acc: 0.9858, Validation acc: 0.9812
Epoch: 27, Train acc: 0.9866, Validation acc: 0.9801
Epoch: 28, Train acc: 0.9885, Validation acc: 0.9836
Epoch: 29, Train acc: 0.9875, Validation acc: 0.9789
Epoch: 30, Train acc: 0.9876, Validation acc: 0.9805
Model saved in path: regular_train/[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11533c6a8>, batch_size_100, keep_prob_0.7]-20180421042046/final_model
Final: Train acc: 0.9877, Test acc: 0.9862, Difference: 0.0015