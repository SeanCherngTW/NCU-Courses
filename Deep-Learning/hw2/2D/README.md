# MNIST Transfer Learning
Restore the model from 1E and train MNIST data 5-9 (100 images per digit)
Using the concept of transfer learning to evaluate the performance

freeze: hidden_layer_1 to hidden_layer_4
trainable: hidden_layer_5 and output_layer

## Summary of 2B, 2D, 2E
### 2B
```
freeze: hidden_layer_1 to hidden_layer_5
trainable: output_layer
test accuracy: 0.7422
```
### 2D
```
freeze: hidden_layer_1 to hidden_layer_4
trainable: hidden_layer_5 and output_layer
test accuracy: 0.7930
```
### 2E
```
freeze: hidden_layer_1 to hidden_layer_3
trainable: hidden_layer_4, hidden_layer_5, output_layer
test accuracy: 0.8348
```
## Output
```
[learning_rate_0.9000, batch_size_50, early_stopping_30]
INFO:tensorflow:Restoring parameters from ./previous_model/final_model
Epoch:   1, Validation loss: 1.1838, Best loss: 1.1838, Accuracy: 0.7191, Best Accuracy:0.7191
Epoch:   2, Validation loss: 1.1892, Best loss: 1.1838, Accuracy: 0.7117, Best Accuracy:0.7191
Epoch:   3, Validation loss: 1.1401, Best loss: 1.1401, Accuracy: 0.7629, Best Accuracy:0.7629
Epoch:   4, Validation loss: 1.1065, Best loss: 1.1065, Accuracy: 0.7961, Best Accuracy:0.7961
Epoch:   5, Validation loss: 1.1089, Best loss: 1.1065, Accuracy: 0.7924, Best Accuracy:0.7961
Epoch:   6, Validation loss: 1.1445, Best loss: 1.1065, Accuracy: 0.7568, Best Accuracy:0.7961
Epoch:   7, Validation loss: 1.1135, Best loss: 1.1065, Accuracy: 0.7887, Best Accuracy:0.7961
Epoch:   8, Validation loss: 1.1289, Best loss: 1.1065, Accuracy: 0.7740, Best Accuracy:0.7961
Epoch:   9, Validation loss: 1.1196, Best loss: 1.1065, Accuracy: 0.7834, Best Accuracy:0.7961
Epoch:  10, Validation loss: 1.1105, Best loss: 1.1065, Accuracy: 0.7920, Best Accuracy:0.7961
Epoch:  11, Validation loss: 1.1198, Best loss: 1.1065, Accuracy: 0.7809, Best Accuracy:0.7961
Epoch:  12, Validation loss: 1.1150, Best loss: 1.1065, Accuracy: 0.7867, Best Accuracy:0.7961
Epoch:  13, Validation loss: 1.1077, Best loss: 1.1065, Accuracy: 0.7920, Best Accuracy:0.7961
Epoch:  14, Validation loss: 1.1382, Best loss: 1.1065, Accuracy: 0.7629, Best Accuracy:0.7961
Epoch:  15, Validation loss: 1.1046, Best loss: 1.1046, Accuracy: 0.7965, Best Accuracy:0.7965
Epoch:  16, Validation loss: 1.1340, Best loss: 1.1046, Accuracy: 0.7658, Best Accuracy:0.7965
Epoch:  17, Validation loss: 1.1093, Best loss: 1.1046, Accuracy: 0.7895, Best Accuracy:0.7965
Epoch:  18, Validation loss: 1.1037, Best loss: 1.1037, Accuracy: 0.7998, Best Accuracy:0.7998
Epoch:  19, Validation loss: 1.1010, Best loss: 1.1010, Accuracy: 0.8022, Best Accuracy:0.8022
Epoch:  20, Validation loss: 1.1018, Best loss: 1.1010, Accuracy: 0.8018, Best Accuracy:0.8022
Epoch:  21, Validation loss: 1.1040, Best loss: 1.1010, Accuracy: 0.7977, Best Accuracy:0.8022
Epoch:  22, Validation loss: 1.1044, Best loss: 1.1010, Accuracy: 0.7993, Best Accuracy:0.8022
Epoch:  23, Validation loss: 1.1002, Best loss: 1.1010, Accuracy: 0.8018, Best Accuracy:0.8022
Epoch:  24, Validation loss: 1.1047, Best loss: 1.1010, Accuracy: 0.7985, Best Accuracy:0.8022
Epoch:  25, Validation loss: 1.0983, Best loss: 1.0983, Accuracy: 0.8047, Best Accuracy:0.8047
Epoch:  26, Validation loss: 1.0997, Best loss: 1.0983, Accuracy: 0.8030, Best Accuracy:0.8047
Epoch:  27, Validation loss: 1.0989, Best loss: 1.0983, Accuracy: 0.8026, Best Accuracy:0.8047
Epoch:  28, Validation loss: 1.0964, Best loss: 1.0964, Accuracy: 0.8071, Best Accuracy:0.8071
Epoch:  29, Validation loss: 1.0967, Best loss: 1.0964, Accuracy: 0.8055, Best Accuracy:0.8071
Epoch:  30, Validation loss: 1.0959, Best loss: 1.0964, Accuracy: 0.8051, Best Accuracy:0.8071
Epoch:  31, Validation loss: 1.0954, Best loss: 1.0964, Accuracy: 0.8067, Best Accuracy:0.8071
Epoch:  32, Validation loss: 1.0953, Best loss: 1.0964, Accuracy: 0.8063, Best Accuracy:0.8071
Epoch:  33, Validation loss: 1.0959, Best loss: 1.0964, Accuracy: 0.8067, Best Accuracy:0.8071
Epoch:  34, Validation loss: 1.0936, Best loss: 1.0936, Accuracy: 0.8096, Best Accuracy:0.8096
Epoch:  35, Validation loss: 1.0950, Best loss: 1.0936, Accuracy: 0.8088, Best Accuracy:0.8096
Epoch:  36, Validation loss: 1.0945, Best loss: 1.0936, Accuracy: 0.8079, Best Accuracy:0.8096
Epoch:  37, Validation loss: 1.0942, Best loss: 1.0942, Accuracy: 0.8104, Best Accuracy:0.8104
Epoch:  38, Validation loss: 1.0929, Best loss: 1.0942, Accuracy: 0.8096, Best Accuracy:0.8104
Epoch:  39, Validation loss: 1.0882, Best loss: 1.0882, Accuracy: 0.8141, Best Accuracy:0.8141
Epoch:  40, Validation loss: 1.0885, Best loss: 1.0885, Accuracy: 0.8161, Best Accuracy:0.8161
Epoch:  41, Validation loss: 1.0887, Best loss: 1.0887, Accuracy: 0.8170, Best Accuracy:0.8170
Epoch:  42, Validation loss: 1.0880, Best loss: 1.0887, Accuracy: 0.8165, Best Accuracy:0.8170
Epoch:  43, Validation loss: 1.0930, Best loss: 1.0887, Accuracy: 0.8071, Best Accuracy:0.8170
Epoch:  44, Validation loss: 1.0894, Best loss: 1.0887, Accuracy: 0.8124, Best Accuracy:0.8170
Epoch:  45, Validation loss: 1.0914, Best loss: 1.0887, Accuracy: 0.8104, Best Accuracy:0.8170
Epoch:  46, Validation loss: 1.0938, Best loss: 1.0887, Accuracy: 0.8108, Best Accuracy:0.8170
Epoch:  47, Validation loss: 1.0924, Best loss: 1.0887, Accuracy: 0.8096, Best Accuracy:0.8170
Epoch:  48, Validation loss: 1.0938, Best loss: 1.0887, Accuracy: 0.8079, Best Accuracy:0.8170
Epoch:  49, Validation loss: 1.0917, Best loss: 1.0887, Accuracy: 0.8100, Best Accuracy:0.8170
Epoch:  50, Validation loss: 1.0922, Best loss: 1.0887, Accuracy: 0.8108, Best Accuracy:0.8170
Epoch:  51, Validation loss: 1.0904, Best loss: 1.0887, Accuracy: 0.8124, Best Accuracy:0.8170
Epoch:  52, Validation loss: 1.0913, Best loss: 1.0887, Accuracy: 0.8112, Best Accuracy:0.8170
Epoch:  53, Validation loss: 1.0904, Best loss: 1.0887, Accuracy: 0.8133, Best Accuracy:0.8170
Epoch:  54, Validation loss: 1.0914, Best loss: 1.0887, Accuracy: 0.8112, Best Accuracy:0.8170
Epoch:  55, Validation loss: 1.0906, Best loss: 1.0887, Accuracy: 0.8153, Best Accuracy:0.8170
Epoch:  56, Validation loss: 1.0911, Best loss: 1.0887, Accuracy: 0.8129, Best Accuracy:0.8170
Epoch:  57, Validation loss: 1.0913, Best loss: 1.0887, Accuracy: 0.8120, Best Accuracy:0.8170
Epoch:  58, Validation loss: 1.0910, Best loss: 1.0887, Accuracy: 0.8112, Best Accuracy:0.8170
Epoch:  59, Validation loss: 1.0906, Best loss: 1.0887, Accuracy: 0.8137, Best Accuracy:0.8170
Epoch:  60, Validation loss: 1.0904, Best loss: 1.0887, Accuracy: 0.8133, Best Accuracy:0.8170
Epoch:  61, Validation loss: 1.0906, Best loss: 1.0887, Accuracy: 0.8141, Best Accuracy:0.8170
Epoch:  62, Validation loss: 1.0909, Best loss: 1.0887, Accuracy: 0.8133, Best Accuracy:0.8170
Epoch:  63, Validation loss: 1.0902, Best loss: 1.0887, Accuracy: 0.8129, Best Accuracy:0.8170
Epoch:  64, Validation loss: 1.0909, Best loss: 1.0887, Accuracy: 0.8137, Best Accuracy:0.8170
Epoch:  65, Validation loss: 1.0906, Best loss: 1.0887, Accuracy: 0.8096, Best Accuracy:0.8170
Epoch:  66, Validation loss: 1.0936, Best loss: 1.0887, Accuracy: 0.8088, Best Accuracy:0.8170
Epoch:  67, Validation loss: 1.0940, Best loss: 1.0887, Accuracy: 0.8088, Best Accuracy:0.8170
Epoch:  68, Validation loss: 1.0927, Best loss: 1.0887, Accuracy: 0.8092, Best Accuracy:0.8170
Epoch:  69, Validation loss: 1.0938, Best loss: 1.0887, Accuracy: 0.8067, Best Accuracy:0.8170
Epoch:  70, Validation loss: 1.0934, Best loss: 1.0887, Accuracy: 0.8084, Best Accuracy:0.8170
Epoch:  71, Validation loss: 1.0932, Best loss: 1.0887, Accuracy: 0.8092, Best Accuracy:0.8170
Epoch:  72, Validation loss: 1.0930, Best loss: 1.0887, Accuracy: 0.8084, Best Accuracy:0.8170
Early Stopping at epoch 72
Total training time: 6.1s
Final test accuracy: 0.7930
```