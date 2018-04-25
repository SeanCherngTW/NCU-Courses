# MNIST Transfer Learning
Restore the model from 1E and train MNIST data 5-9 (100 images per digit)
Using the concept of transfer learning to evaluate the performance

freeze: hidden_layer_1 to hidden_layer_3
trainable: hidden_layer_4, hidden_layer_5, output_layer

## Summary of 2B, 2D, 2E
### 2B
```
freeze: hidden_layer_1 to hidden_layer_5
trainable: output_layer
test accuracy: 0.7449
```
### 2D
```
freeze: hidden_layer_1 to hidden_layer_4
trainable: hidden_layer_5 and output_layer
test accuracy: 0.7743
```
### 2E
```
freeze: hidden_layer_1 to hidden_layer_3
trainable: hidden_layer_4, hidden_layer_5, output_layer
test accuracy: 0.7953
```
## Output
```
[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11c1636a8>, batch_size_100, batch_normalization_True]
INFO:tensorflow:Restoring parameters from ./previous_model/final_model.ckpt
Epoch:   1, Validation loss: 1.5272, Best loss: 1.5272, Accuracy: 0.3632, Best Accuracy:0.3632
Epoch:   2, Validation loss: 1.4985, Best loss: 1.4985, Accuracy: 0.3911, Best Accuracy:0.3911
Epoch:   3, Validation loss: 1.4683, Best loss: 1.4683, Accuracy: 0.4201, Best Accuracy:0.4201
Epoch:   4, Validation loss: 1.4378, Best loss: 1.4378, Accuracy: 0.4525, Best Accuracy:0.4525
Epoch:   5, Validation loss: 1.4056, Best loss: 1.4056, Accuracy: 0.4910, Best Accuracy:0.4910
Epoch:   6, Validation loss: 1.3769, Best loss: 1.3769, Accuracy: 0.5168, Best Accuracy:0.5168
Epoch:   7, Validation loss: 1.3533, Best loss: 1.3533, Accuracy: 0.5426, Best Accuracy:0.5426
Epoch:   8, Validation loss: 1.3313, Best loss: 1.3313, Accuracy: 0.5684, Best Accuracy:0.5684
Epoch:   9, Validation loss: 1.3076, Best loss: 1.3076, Accuracy: 0.5930, Best Accuracy:0.5930
Epoch:  10, Validation loss: 1.2854, Best loss: 1.2854, Accuracy: 0.6196, Best Accuracy:0.6196
Epoch:  11, Validation loss: 1.2674, Best loss: 1.2674, Accuracy: 0.6392, Best Accuracy:0.6392
Epoch:  12, Validation loss: 1.2546, Best loss: 1.2546, Accuracy: 0.6503, Best Accuracy:0.6503
Epoch:  13, Validation loss: 1.2445, Best loss: 1.2445, Accuracy: 0.6577, Best Accuracy:0.6577
Epoch:  14, Validation loss: 1.2358, Best loss: 1.2358, Accuracy: 0.6658, Best Accuracy:0.6658
Epoch:  15, Validation loss: 1.2272, Best loss: 1.2272, Accuracy: 0.6769, Best Accuracy:0.6769
Epoch:  16, Validation loss: 1.2186, Best loss: 1.2186, Accuracy: 0.6867, Best Accuracy:0.6867
Epoch:  17, Validation loss: 1.2100, Best loss: 1.2100, Accuracy: 0.6974, Best Accuracy:0.6974
Epoch:  18, Validation loss: 1.2026, Best loss: 1.2026, Accuracy: 0.7015, Best Accuracy:0.7015
Epoch:  19, Validation loss: 1.1968, Best loss: 1.1968, Accuracy: 0.7088, Best Accuracy:0.7088
Epoch:  20, Validation loss: 1.1910, Best loss: 1.1910, Accuracy: 0.7129, Best Accuracy:0.7129
Epoch:  21, Validation loss: 1.1850, Best loss: 1.1850, Accuracy: 0.7224, Best Accuracy:0.7224
Epoch:  22, Validation loss: 1.1798, Best loss: 1.1798, Accuracy: 0.7277, Best Accuracy:0.7277
Epoch:  23, Validation loss: 1.1756, Best loss: 1.1756, Accuracy: 0.7310, Best Accuracy:0.7310
Epoch:  24, Validation loss: 1.1720, Best loss: 1.1720, Accuracy: 0.7330, Best Accuracy:0.7330
Epoch:  25, Validation loss: 1.1683, Best loss: 1.1683, Accuracy: 0.7371, Best Accuracy:0.7371
Epoch:  26, Validation loss: 1.1649, Best loss: 1.1649, Accuracy: 0.7408, Best Accuracy:0.7408
Epoch:  27, Validation loss: 1.1618, Best loss: 1.1618, Accuracy: 0.7424, Best Accuracy:0.7424
Epoch:  28, Validation loss: 1.1591, Best loss: 1.1591, Accuracy: 0.7441, Best Accuracy:0.7441
Epoch:  29, Validation loss: 1.1565, Best loss: 1.1565, Accuracy: 0.7445, Best Accuracy:0.7445
Epoch:  30, Validation loss: 1.1539, Best loss: 1.1539, Accuracy: 0.7453, Best Accuracy:0.7453
Epoch:  31, Validation loss: 1.1513, Best loss: 1.1513, Accuracy: 0.7523, Best Accuracy:0.7523
Epoch:  32, Validation loss: 1.1483, Best loss: 1.1483, Accuracy: 0.7563, Best Accuracy:0.7563
Epoch:  33, Validation loss: 1.1455, Best loss: 1.1455, Accuracy: 0.7580, Best Accuracy:0.7580
Epoch:  34, Validation loss: 1.1430, Best loss: 1.1430, Accuracy: 0.7596, Best Accuracy:0.7596
Epoch:  35, Validation loss: 1.1408, Best loss: 1.1408, Accuracy: 0.7621, Best Accuracy:0.7621
Epoch:  36, Validation loss: 1.1388, Best loss: 1.1388, Accuracy: 0.7674, Best Accuracy:0.7674
Epoch:  37, Validation loss: 1.1368, Best loss: 1.1368, Accuracy: 0.7695, Best Accuracy:0.7695
Epoch:  38, Validation loss: 1.1348, Best loss: 1.1348, Accuracy: 0.7735, Best Accuracy:0.7735
Epoch:  39, Validation loss: 1.1327, Best loss: 1.1327, Accuracy: 0.7756, Best Accuracy:0.7756
Epoch:  40, Validation loss: 1.1308, Best loss: 1.1308, Accuracy: 0.7781, Best Accuracy:0.7781
Epoch:  41, Validation loss: 1.1294, Best loss: 1.1294, Accuracy: 0.7805, Best Accuracy:0.7805
Epoch:  42, Validation loss: 1.1282, Best loss: 1.1282, Accuracy: 0.7830, Best Accuracy:0.7830
Epoch:  43, Validation loss: 1.1273, Best loss: 1.1273, Accuracy: 0.7842, Best Accuracy:0.7842
Epoch:  44, Validation loss: 1.1264, Best loss: 1.1264, Accuracy: 0.7858, Best Accuracy:0.7858
Epoch:  45, Validation loss: 1.1257, Best loss: 1.1264, Accuracy: 0.7842, Best Accuracy:0.7858
Epoch:  46, Validation loss: 1.1250, Best loss: 1.1264, Accuracy: 0.7854, Best Accuracy:0.7858
Epoch:  47, Validation loss: 1.1242, Best loss: 1.1242, Accuracy: 0.7862, Best Accuracy:0.7862
Epoch:  48, Validation loss: 1.1234, Best loss: 1.1234, Accuracy: 0.7871, Best Accuracy:0.7871
Epoch:  49, Validation loss: 1.1226, Best loss: 1.1226, Accuracy: 0.7871, Best Accuracy:0.7871
Epoch:  50, Validation loss: 1.1218, Best loss: 1.1218, Accuracy: 0.7891, Best Accuracy:0.7891
Epoch:  51, Validation loss: 1.1211, Best loss: 1.1211, Accuracy: 0.7903, Best Accuracy:0.7903
Epoch:  52, Validation loss: 1.1204, Best loss: 1.1204, Accuracy: 0.7907, Best Accuracy:0.7907
Epoch:  53, Validation loss: 1.1197, Best loss: 1.1204, Accuracy: 0.7903, Best Accuracy:0.7907
Epoch:  54, Validation loss: 1.1191, Best loss: 1.1191, Accuracy: 0.7920, Best Accuracy:0.7920
Epoch:  55, Validation loss: 1.1185, Best loss: 1.1191, Accuracy: 0.7916, Best Accuracy:0.7920
Epoch:  56, Validation loss: 1.1180, Best loss: 1.1191, Accuracy: 0.7907, Best Accuracy:0.7920
Epoch:  57, Validation loss: 1.1175, Best loss: 1.1191, Accuracy: 0.7895, Best Accuracy:0.7920
Epoch:  58, Validation loss: 1.1170, Best loss: 1.1191, Accuracy: 0.7891, Best Accuracy:0.7920
Epoch:  59, Validation loss: 1.1165, Best loss: 1.1191, Accuracy: 0.7899, Best Accuracy:0.7920
Epoch:  60, Validation loss: 1.1160, Best loss: 1.1191, Accuracy: 0.7891, Best Accuracy:0.7920
Epoch:  61, Validation loss: 1.1154, Best loss: 1.1191, Accuracy: 0.7895, Best Accuracy:0.7920
Epoch:  62, Validation loss: 1.1147, Best loss: 1.1191, Accuracy: 0.7907, Best Accuracy:0.7920
Epoch:  63, Validation loss: 1.1142, Best loss: 1.1191, Accuracy: 0.7891, Best Accuracy:0.7920
Epoch:  64, Validation loss: 1.1136, Best loss: 1.1191, Accuracy: 0.7887, Best Accuracy:0.7920
Epoch:  65, Validation loss: 1.1131, Best loss: 1.1191, Accuracy: 0.7895, Best Accuracy:0.7920
Epoch:  66, Validation loss: 1.1126, Best loss: 1.1191, Accuracy: 0.7912, Best Accuracy:0.7920
Epoch:  67, Validation loss: 1.1120, Best loss: 1.1120, Accuracy: 0.7920, Best Accuracy:0.7920
Epoch:  68, Validation loss: 1.1115, Best loss: 1.1115, Accuracy: 0.7928, Best Accuracy:0.7928
Epoch:  69, Validation loss: 1.1110, Best loss: 1.1110, Accuracy: 0.7940, Best Accuracy:0.7940
Epoch:  70, Validation loss: 1.1105, Best loss: 1.1105, Accuracy: 0.7940, Best Accuracy:0.7940
Epoch:  71, Validation loss: 1.1100, Best loss: 1.1100, Accuracy: 0.7961, Best Accuracy:0.7961
Epoch:  72, Validation loss: 1.1095, Best loss: 1.1095, Accuracy: 0.7973, Best Accuracy:0.7973
Epoch:  73, Validation loss: 1.1090, Best loss: 1.1090, Accuracy: 0.7977, Best Accuracy:0.7977
Epoch:  74, Validation loss: 1.1086, Best loss: 1.1086, Accuracy: 0.7981, Best Accuracy:0.7981
Epoch:  75, Validation loss: 1.1083, Best loss: 1.1083, Accuracy: 0.7993, Best Accuracy:0.7993
Epoch:  76, Validation loss: 1.1079, Best loss: 1.1083, Accuracy: 0.7989, Best Accuracy:0.7993
Epoch:  77, Validation loss: 1.1076, Best loss: 1.1083, Accuracy: 0.7965, Best Accuracy:0.7993
Epoch:  78, Validation loss: 1.1074, Best loss: 1.1083, Accuracy: 0.7961, Best Accuracy:0.7993
Epoch:  79, Validation loss: 1.1072, Best loss: 1.1083, Accuracy: 0.7973, Best Accuracy:0.7993
Epoch:  80, Validation loss: 1.1070, Best loss: 1.1083, Accuracy: 0.7981, Best Accuracy:0.7993
Epoch:  81, Validation loss: 1.1068, Best loss: 1.1083, Accuracy: 0.7973, Best Accuracy:0.7993
Epoch:  82, Validation loss: 1.1066, Best loss: 1.1083, Accuracy: 0.7969, Best Accuracy:0.7993
Epoch:  83, Validation loss: 1.1064, Best loss: 1.1083, Accuracy: 0.7969, Best Accuracy:0.7993
Epoch:  84, Validation loss: 1.1062, Best loss: 1.1062, Accuracy: 0.7993, Best Accuracy:0.7993
Epoch:  85, Validation loss: 1.1060, Best loss: 1.1062, Accuracy: 0.7989, Best Accuracy:0.7993
Epoch:  86, Validation loss: 1.1059, Best loss: 1.1059, Accuracy: 0.7998, Best Accuracy:0.7998
Epoch:  87, Validation loss: 1.1057, Best loss: 1.1057, Accuracy: 0.8002, Best Accuracy:0.8002
Epoch:  88, Validation loss: 1.1055, Best loss: 1.1057, Accuracy: 0.7998, Best Accuracy:0.8002
Epoch:  89, Validation loss: 1.1054, Best loss: 1.1057, Accuracy: 0.7998, Best Accuracy:0.8002
Epoch:  90, Validation loss: 1.1052, Best loss: 1.1057, Accuracy: 0.7998, Best Accuracy:0.8002
Epoch:  91, Validation loss: 1.1050, Best loss: 1.1057, Accuracy: 0.7998, Best Accuracy:0.8002
Epoch:  92, Validation loss: 1.1048, Best loss: 1.1048, Accuracy: 0.8002, Best Accuracy:0.8002
Epoch:  93, Validation loss: 1.1045, Best loss: 1.1048, Accuracy: 0.7998, Best Accuracy:0.8002
Epoch:  94, Validation loss: 1.1042, Best loss: 1.1048, Accuracy: 0.7993, Best Accuracy:0.8002
Epoch:  95, Validation loss: 1.1040, Best loss: 1.1040, Accuracy: 0.8002, Best Accuracy:0.8002
Epoch:  96, Validation loss: 1.1037, Best loss: 1.1037, Accuracy: 0.8010, Best Accuracy:0.8010
Epoch:  97, Validation loss: 1.1034, Best loss: 1.1034, Accuracy: 0.8022, Best Accuracy:0.8022
Epoch:  98, Validation loss: 1.1032, Best loss: 1.1032, Accuracy: 0.8026, Best Accuracy:0.8026
Epoch:  99, Validation loss: 1.1029, Best loss: 1.1032, Accuracy: 0.8022, Best Accuracy:0.8026
Epoch: 100, Validation loss: 1.1027, Best loss: 1.1027, Accuracy: 0.8026, Best Accuracy:0.8026
Epoch: 101, Validation loss: 1.1024, Best loss: 1.1024, Accuracy: 0.8034, Best Accuracy:0.8034
Epoch: 102, Validation loss: 1.1021, Best loss: 1.1024, Accuracy: 0.8030, Best Accuracy:0.8034
Epoch: 103, Validation loss: 1.1019, Best loss: 1.1019, Accuracy: 0.8034, Best Accuracy:0.8034
Epoch: 104, Validation loss: 1.1016, Best loss: 1.1016, Accuracy: 0.8047, Best Accuracy:0.8047
Epoch: 105, Validation loss: 1.1013, Best loss: 1.1013, Accuracy: 0.8051, Best Accuracy:0.8051
Epoch: 106, Validation loss: 1.1011, Best loss: 1.1011, Accuracy: 0.8063, Best Accuracy:0.8063
Epoch: 107, Validation loss: 1.1009, Best loss: 1.1009, Accuracy: 0.8067, Best Accuracy:0.8067
Epoch: 108, Validation loss: 1.1008, Best loss: 1.1009, Accuracy: 0.8063, Best Accuracy:0.8067
Epoch: 109, Validation loss: 1.1006, Best loss: 1.1009, Accuracy: 0.8059, Best Accuracy:0.8067
Epoch: 110, Validation loss: 1.1005, Best loss: 1.1009, Accuracy: 0.8059, Best Accuracy:0.8067
Epoch: 111, Validation loss: 1.1004, Best loss: 1.1004, Accuracy: 0.8067, Best Accuracy:0.8067
Epoch: 112, Validation loss: 1.1003, Best loss: 1.1003, Accuracy: 0.8075, Best Accuracy:0.8075
Epoch: 113, Validation loss: 1.1002, Best loss: 1.1002, Accuracy: 0.8075, Best Accuracy:0.8075
Epoch: 114, Validation loss: 1.1001, Best loss: 1.1001, Accuracy: 0.8079, Best Accuracy:0.8079
Epoch: 115, Validation loss: 1.1000, Best loss: 1.1001, Accuracy: 0.8075, Best Accuracy:0.8079
Epoch: 116, Validation loss: 1.0999, Best loss: 1.0999, Accuracy: 0.8079, Best Accuracy:0.8079
Epoch: 117, Validation loss: 1.0998, Best loss: 1.0998, Accuracy: 0.8092, Best Accuracy:0.8092
Epoch: 118, Validation loss: 1.0997, Best loss: 1.0997, Accuracy: 0.8096, Best Accuracy:0.8096
Epoch: 119, Validation loss: 1.0996, Best loss: 1.0996, Accuracy: 0.8096, Best Accuracy:0.8096
Epoch: 120, Validation loss: 1.0995, Best loss: 1.0996, Accuracy: 0.8088, Best Accuracy:0.8096
Epoch: 121, Validation loss: 1.0994, Best loss: 1.0996, Accuracy: 0.8088, Best Accuracy:0.8096
Epoch: 122, Validation loss: 1.0994, Best loss: 1.0996, Accuracy: 0.8079, Best Accuracy:0.8096
Epoch: 123, Validation loss: 1.0993, Best loss: 1.0996, Accuracy: 0.8079, Best Accuracy:0.8096
Epoch: 124, Validation loss: 1.0993, Best loss: 1.0996, Accuracy: 0.8071, Best Accuracy:0.8096
Epoch: 125, Validation loss: 1.0992, Best loss: 1.0996, Accuracy: 0.8067, Best Accuracy:0.8096
Epoch: 126, Validation loss: 1.0992, Best loss: 1.0996, Accuracy: 0.8067, Best Accuracy:0.8096
Epoch: 127, Validation loss: 1.0992, Best loss: 1.0996, Accuracy: 0.8067, Best Accuracy:0.8096
Epoch: 128, Validation loss: 1.0992, Best loss: 1.0996, Accuracy: 0.8067, Best Accuracy:0.8096
Epoch: 129, Validation loss: 1.0992, Best loss: 1.0996, Accuracy: 0.8063, Best Accuracy:0.8096
Epoch: 130, Validation loss: 1.0992, Best loss: 1.0996, Accuracy: 0.8055, Best Accuracy:0.8096
Epoch: 131, Validation loss: 1.0993, Best loss: 1.0996, Accuracy: 0.8059, Best Accuracy:0.8096
Epoch: 132, Validation loss: 1.0994, Best loss: 1.0996, Accuracy: 0.8067, Best Accuracy:0.8096
Epoch: 133, Validation loss: 1.0995, Best loss: 1.0996, Accuracy: 0.8063, Best Accuracy:0.8096
Epoch: 134, Validation loss: 1.0996, Best loss: 1.0996, Accuracy: 0.8055, Best Accuracy:0.8096
Epoch: 135, Validation loss: 1.0998, Best loss: 1.0996, Accuracy: 0.8055, Best Accuracy:0.8096
Epoch: 136, Validation loss: 1.1001, Best loss: 1.0996, Accuracy: 0.8047, Best Accuracy:0.8096
Epoch: 137, Validation loss: 1.1005, Best loss: 1.0996, Accuracy: 0.8047, Best Accuracy:0.8096
Epoch: 138, Validation loss: 1.1008, Best loss: 1.0996, Accuracy: 0.8051, Best Accuracy:0.8096
Epoch: 139, Validation loss: 1.1011, Best loss: 1.0996, Accuracy: 0.8055, Best Accuracy:0.8096
Epoch: 140, Validation loss: 1.1012, Best loss: 1.0996, Accuracy: 0.8051, Best Accuracy:0.8096
Early Stopping at epoch 140
Total training time: 10.4s
Final test accuracy: 0.7953
```