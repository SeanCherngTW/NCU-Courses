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
[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x118a2f6a8>, batch_size_100, batch_normalization_True]
INFO:tensorflow:Restoring parameters from ./previous_model/final_model.ckpt
Epoch:   1, Validation loss: 1.5449, Best loss: 1.5449, Accuracy: 0.3448, Best Accuracy:0.3448
Epoch:   2, Validation loss: 1.5353, Best loss: 1.5353, Accuracy: 0.3534, Best Accuracy:0.3534
Epoch:   3, Validation loss: 1.5256, Best loss: 1.5256, Accuracy: 0.3628, Best Accuracy:0.3628
Epoch:   4, Validation loss: 1.5157, Best loss: 1.5157, Accuracy: 0.3702, Best Accuracy:0.3702
Epoch:   5, Validation loss: 1.5054, Best loss: 1.5054, Accuracy: 0.3817, Best Accuracy:0.3817
Epoch:   6, Validation loss: 1.4948, Best loss: 1.4948, Accuracy: 0.3915, Best Accuracy:0.3915
Epoch:   7, Validation loss: 1.4840, Best loss: 1.4840, Accuracy: 0.4042, Best Accuracy:0.4042
Epoch:   8, Validation loss: 1.4728, Best loss: 1.4728, Accuracy: 0.4165, Best Accuracy:0.4165
Epoch:   9, Validation loss: 1.4612, Best loss: 1.4612, Accuracy: 0.4320, Best Accuracy:0.4320
Epoch:  10, Validation loss: 1.4493, Best loss: 1.4493, Accuracy: 0.4435, Best Accuracy:0.4435
Epoch:  11, Validation loss: 1.4369, Best loss: 1.4369, Accuracy: 0.4586, Best Accuracy:0.4586
Epoch:  12, Validation loss: 1.4234, Best loss: 1.4234, Accuracy: 0.4734, Best Accuracy:0.4734
Epoch:  13, Validation loss: 1.4092, Best loss: 1.4092, Accuracy: 0.4873, Best Accuracy:0.4873
Epoch:  14, Validation loss: 1.3953, Best loss: 1.3953, Accuracy: 0.5000, Best Accuracy:0.5000
Epoch:  15, Validation loss: 1.3816, Best loss: 1.3816, Accuracy: 0.5106, Best Accuracy:0.5106
Epoch:  16, Validation loss: 1.3681, Best loss: 1.3681, Accuracy: 0.5266, Best Accuracy:0.5266
Epoch:  17, Validation loss: 1.3552, Best loss: 1.3552, Accuracy: 0.5418, Best Accuracy:0.5418
Epoch:  18, Validation loss: 1.3427, Best loss: 1.3427, Accuracy: 0.5549, Best Accuracy:0.5549
Epoch:  19, Validation loss: 1.3303, Best loss: 1.3303, Accuracy: 0.5713, Best Accuracy:0.5713
Epoch:  20, Validation loss: 1.3177, Best loss: 1.3177, Accuracy: 0.5835, Best Accuracy:0.5835
Epoch:  21, Validation loss: 1.3055, Best loss: 1.3055, Accuracy: 0.5950, Best Accuracy:0.5950
Epoch:  22, Validation loss: 1.2942, Best loss: 1.2942, Accuracy: 0.6085, Best Accuracy:0.6085
Epoch:  23, Validation loss: 1.2840, Best loss: 1.2840, Accuracy: 0.6183, Best Accuracy:0.6183
Epoch:  24, Validation loss: 1.2744, Best loss: 1.2744, Accuracy: 0.6274, Best Accuracy:0.6274
Epoch:  25, Validation loss: 1.2654, Best loss: 1.2654, Accuracy: 0.6343, Best Accuracy:0.6343
Epoch:  26, Validation loss: 1.2569, Best loss: 1.2569, Accuracy: 0.6437, Best Accuracy:0.6437
Epoch:  27, Validation loss: 1.2482, Best loss: 1.2482, Accuracy: 0.6560, Best Accuracy:0.6560
Epoch:  28, Validation loss: 1.2390, Best loss: 1.2390, Accuracy: 0.6691, Best Accuracy:0.6691
Epoch:  29, Validation loss: 1.2302, Best loss: 1.2302, Accuracy: 0.6785, Best Accuracy:0.6785
Epoch:  30, Validation loss: 1.2234, Best loss: 1.2234, Accuracy: 0.6867, Best Accuracy:0.6867
Epoch:  31, Validation loss: 1.2182, Best loss: 1.2182, Accuracy: 0.6871, Best Accuracy:0.6871
Epoch:  32, Validation loss: 1.2139, Best loss: 1.2139, Accuracy: 0.6916, Best Accuracy:0.6916
Epoch:  33, Validation loss: 1.2101, Best loss: 1.2101, Accuracy: 0.6966, Best Accuracy:0.6966
Epoch:  34, Validation loss: 1.2066, Best loss: 1.2066, Accuracy: 0.7002, Best Accuracy:0.7002
Epoch:  35, Validation loss: 1.2033, Best loss: 1.2033, Accuracy: 0.7011, Best Accuracy:0.7011
Epoch:  36, Validation loss: 1.2000, Best loss: 1.2000, Accuracy: 0.7039, Best Accuracy:0.7039
Epoch:  37, Validation loss: 1.1969, Best loss: 1.1969, Accuracy: 0.7080, Best Accuracy:0.7080
Epoch:  38, Validation loss: 1.1940, Best loss: 1.1940, Accuracy: 0.7113, Best Accuracy:0.7113
Epoch:  39, Validation loss: 1.1912, Best loss: 1.1912, Accuracy: 0.7158, Best Accuracy:0.7158
Epoch:  40, Validation loss: 1.1887, Best loss: 1.1887, Accuracy: 0.7183, Best Accuracy:0.7183
Epoch:  41, Validation loss: 1.1863, Best loss: 1.1863, Accuracy: 0.7199, Best Accuracy:0.7199
Epoch:  42, Validation loss: 1.1842, Best loss: 1.1863, Accuracy: 0.7195, Best Accuracy:0.7199
Epoch:  43, Validation loss: 1.1821, Best loss: 1.1821, Accuracy: 0.7199, Best Accuracy:0.7199
Epoch:  44, Validation loss: 1.1802, Best loss: 1.1802, Accuracy: 0.7224, Best Accuracy:0.7224
Epoch:  45, Validation loss: 1.1783, Best loss: 1.1783, Accuracy: 0.7248, Best Accuracy:0.7248
Epoch:  46, Validation loss: 1.1764, Best loss: 1.1764, Accuracy: 0.7281, Best Accuracy:0.7281
Epoch:  47, Validation loss: 1.1745, Best loss: 1.1745, Accuracy: 0.7301, Best Accuracy:0.7301
Epoch:  48, Validation loss: 1.1727, Best loss: 1.1727, Accuracy: 0.7305, Best Accuracy:0.7305
Epoch:  49, Validation loss: 1.1710, Best loss: 1.1710, Accuracy: 0.7326, Best Accuracy:0.7326
Epoch:  50, Validation loss: 1.1693, Best loss: 1.1693, Accuracy: 0.7330, Best Accuracy:0.7330
Epoch:  51, Validation loss: 1.1676, Best loss: 1.1676, Accuracy: 0.7334, Best Accuracy:0.7334
Epoch:  52, Validation loss: 1.1661, Best loss: 1.1661, Accuracy: 0.7342, Best Accuracy:0.7342
Epoch:  53, Validation loss: 1.1646, Best loss: 1.1646, Accuracy: 0.7355, Best Accuracy:0.7355
Epoch:  54, Validation loss: 1.1632, Best loss: 1.1632, Accuracy: 0.7367, Best Accuracy:0.7367
Epoch:  55, Validation loss: 1.1618, Best loss: 1.1618, Accuracy: 0.7387, Best Accuracy:0.7387
Epoch:  56, Validation loss: 1.1604, Best loss: 1.1604, Accuracy: 0.7449, Best Accuracy:0.7449
Epoch:  57, Validation loss: 1.1591, Best loss: 1.1591, Accuracy: 0.7457, Best Accuracy:0.7457
Epoch:  58, Validation loss: 1.1579, Best loss: 1.1579, Accuracy: 0.7486, Best Accuracy:0.7486
Epoch:  59, Validation loss: 1.1566, Best loss: 1.1579, Accuracy: 0.7482, Best Accuracy:0.7486
Epoch:  60, Validation loss: 1.1554, Best loss: 1.1554, Accuracy: 0.7518, Best Accuracy:0.7518
Epoch:  61, Validation loss: 1.1543, Best loss: 1.1543, Accuracy: 0.7523, Best Accuracy:0.7523
Epoch:  62, Validation loss: 1.1533, Best loss: 1.1533, Accuracy: 0.7547, Best Accuracy:0.7547
Epoch:  63, Validation loss: 1.1521, Best loss: 1.1521, Accuracy: 0.7547, Best Accuracy:0.7547
Epoch:  64, Validation loss: 1.1510, Best loss: 1.1510, Accuracy: 0.7547, Best Accuracy:0.7547
Epoch:  65, Validation loss: 1.1498, Best loss: 1.1498, Accuracy: 0.7568, Best Accuracy:0.7568
Epoch:  66, Validation loss: 1.1487, Best loss: 1.1487, Accuracy: 0.7580, Best Accuracy:0.7580
Epoch:  67, Validation loss: 1.1476, Best loss: 1.1476, Accuracy: 0.7604, Best Accuracy:0.7604
Epoch:  68, Validation loss: 1.1467, Best loss: 1.1467, Accuracy: 0.7629, Best Accuracy:0.7629
Epoch:  69, Validation loss: 1.1458, Best loss: 1.1458, Accuracy: 0.7645, Best Accuracy:0.7645
Epoch:  70, Validation loss: 1.1449, Best loss: 1.1458, Accuracy: 0.7641, Best Accuracy:0.7645
Epoch:  71, Validation loss: 1.1441, Best loss: 1.1441, Accuracy: 0.7666, Best Accuracy:0.7666
Epoch:  72, Validation loss: 1.1433, Best loss: 1.1441, Accuracy: 0.7654, Best Accuracy:0.7666
Epoch:  73, Validation loss: 1.1425, Best loss: 1.1425, Accuracy: 0.7666, Best Accuracy:0.7666
Epoch:  74, Validation loss: 1.1417, Best loss: 1.1417, Accuracy: 0.7666, Best Accuracy:0.7666
Epoch:  75, Validation loss: 1.1409, Best loss: 1.1409, Accuracy: 0.7670, Best Accuracy:0.7670
Epoch:  76, Validation loss: 1.1402, Best loss: 1.1409, Accuracy: 0.7666, Best Accuracy:0.7670
Epoch:  77, Validation loss: 1.1395, Best loss: 1.1395, Accuracy: 0.7674, Best Accuracy:0.7674
Epoch:  78, Validation loss: 1.1388, Best loss: 1.1388, Accuracy: 0.7686, Best Accuracy:0.7686
Epoch:  79, Validation loss: 1.1382, Best loss: 1.1382, Accuracy: 0.7686, Best Accuracy:0.7686
Epoch:  80, Validation loss: 1.1376, Best loss: 1.1382, Accuracy: 0.7682, Best Accuracy:0.7686
Epoch:  81, Validation loss: 1.1371, Best loss: 1.1371, Accuracy: 0.7686, Best Accuracy:0.7686
Epoch:  82, Validation loss: 1.1366, Best loss: 1.1366, Accuracy: 0.7690, Best Accuracy:0.7690
Epoch:  83, Validation loss: 1.1362, Best loss: 1.1362, Accuracy: 0.7695, Best Accuracy:0.7695
Epoch:  84, Validation loss: 1.1358, Best loss: 1.1362, Accuracy: 0.7690, Best Accuracy:0.7695
Epoch:  85, Validation loss: 1.1354, Best loss: 1.1362, Accuracy: 0.7690, Best Accuracy:0.7695
Epoch:  86, Validation loss: 1.1351, Best loss: 1.1362, Accuracy: 0.7682, Best Accuracy:0.7695
Epoch:  87, Validation loss: 1.1348, Best loss: 1.1362, Accuracy: 0.7690, Best Accuracy:0.7695
Epoch:  88, Validation loss: 1.1345, Best loss: 1.1362, Accuracy: 0.7686, Best Accuracy:0.7695
Epoch:  89, Validation loss: 1.1342, Best loss: 1.1362, Accuracy: 0.7690, Best Accuracy:0.7695
Epoch:  90, Validation loss: 1.1340, Best loss: 1.1340, Accuracy: 0.7699, Best Accuracy:0.7699
Epoch:  91, Validation loss: 1.1337, Best loss: 1.1337, Accuracy: 0.7699, Best Accuracy:0.7699
Epoch:  92, Validation loss: 1.1335, Best loss: 1.1335, Accuracy: 0.7703, Best Accuracy:0.7703
Epoch:  93, Validation loss: 1.1333, Best loss: 1.1333, Accuracy: 0.7711, Best Accuracy:0.7711
Epoch:  94, Validation loss: 1.1331, Best loss: 1.1331, Accuracy: 0.7735, Best Accuracy:0.7735
Epoch:  95, Validation loss: 1.1328, Best loss: 1.1328, Accuracy: 0.7740, Best Accuracy:0.7740
Epoch:  96, Validation loss: 1.1326, Best loss: 1.1326, Accuracy: 0.7740, Best Accuracy:0.7740
Epoch:  97, Validation loss: 1.1324, Best loss: 1.1324, Accuracy: 0.7744, Best Accuracy:0.7744
Epoch:  98, Validation loss: 1.1322, Best loss: 1.1322, Accuracy: 0.7744, Best Accuracy:0.7744
Epoch:  99, Validation loss: 1.1320, Best loss: 1.1320, Accuracy: 0.7752, Best Accuracy:0.7752
Epoch: 100, Validation loss: 1.1318, Best loss: 1.1318, Accuracy: 0.7756, Best Accuracy:0.7756
Epoch: 101, Validation loss: 1.1316, Best loss: 1.1316, Accuracy: 0.7756, Best Accuracy:0.7756
Epoch: 102, Validation loss: 1.1314, Best loss: 1.1314, Accuracy: 0.7764, Best Accuracy:0.7764
Epoch: 103, Validation loss: 1.1312, Best loss: 1.1312, Accuracy: 0.7764, Best Accuracy:0.7764
Epoch: 104, Validation loss: 1.1310, Best loss: 1.1312, Accuracy: 0.7756, Best Accuracy:0.7764
Epoch: 105, Validation loss: 1.1309, Best loss: 1.1312, Accuracy: 0.7756, Best Accuracy:0.7764
Epoch: 106, Validation loss: 1.1307, Best loss: 1.1307, Accuracy: 0.7764, Best Accuracy:0.7764
Epoch: 107, Validation loss: 1.1306, Best loss: 1.1306, Accuracy: 0.7781, Best Accuracy:0.7781
Epoch: 108, Validation loss: 1.1305, Best loss: 1.1305, Accuracy: 0.7793, Best Accuracy:0.7793
Epoch: 109, Validation loss: 1.1303, Best loss: 1.1305, Accuracy: 0.7789, Best Accuracy:0.7793
Epoch: 110, Validation loss: 1.1302, Best loss: 1.1305, Accuracy: 0.7785, Best Accuracy:0.7793
Epoch: 111, Validation loss: 1.1300, Best loss: 1.1305, Accuracy: 0.7789, Best Accuracy:0.7793
Epoch: 112, Validation loss: 1.1298, Best loss: 1.1305, Accuracy: 0.7789, Best Accuracy:0.7793
Epoch: 113, Validation loss: 1.1297, Best loss: 1.1305, Accuracy: 0.7785, Best Accuracy:0.7793
Epoch: 114, Validation loss: 1.1295, Best loss: 1.1305, Accuracy: 0.7785, Best Accuracy:0.7793
Epoch: 115, Validation loss: 1.1293, Best loss: 1.1305, Accuracy: 0.7781, Best Accuracy:0.7793
Epoch: 116, Validation loss: 1.1292, Best loss: 1.1305, Accuracy: 0.7785, Best Accuracy:0.7793
Epoch: 117, Validation loss: 1.1290, Best loss: 1.1305, Accuracy: 0.7781, Best Accuracy:0.7793
Epoch: 118, Validation loss: 1.1288, Best loss: 1.1305, Accuracy: 0.7776, Best Accuracy:0.7793
Epoch: 119, Validation loss: 1.1286, Best loss: 1.1305, Accuracy: 0.7785, Best Accuracy:0.7793
Epoch: 120, Validation loss: 1.1285, Best loss: 1.1305, Accuracy: 0.7789, Best Accuracy:0.7793
Epoch: 121, Validation loss: 1.1283, Best loss: 1.1283, Accuracy: 0.7793, Best Accuracy:0.7793
Epoch: 122, Validation loss: 1.1282, Best loss: 1.1282, Accuracy: 0.7797, Best Accuracy:0.7797
Epoch: 123, Validation loss: 1.1280, Best loss: 1.1280, Accuracy: 0.7797, Best Accuracy:0.7797
Epoch: 124, Validation loss: 1.1279, Best loss: 1.1279, Accuracy: 0.7797, Best Accuracy:0.7797
Epoch: 125, Validation loss: 1.1277, Best loss: 1.1277, Accuracy: 0.7797, Best Accuracy:0.7797
Epoch: 126, Validation loss: 1.1276, Best loss: 1.1276, Accuracy: 0.7813, Best Accuracy:0.7813
Epoch: 127, Validation loss: 1.1275, Best loss: 1.1276, Accuracy: 0.7801, Best Accuracy:0.7813
Epoch: 128, Validation loss: 1.1274, Best loss: 1.1276, Accuracy: 0.7809, Best Accuracy:0.7813
Epoch: 129, Validation loss: 1.1273, Best loss: 1.1273, Accuracy: 0.7813, Best Accuracy:0.7813
Epoch: 130, Validation loss: 1.1272, Best loss: 1.1272, Accuracy: 0.7821, Best Accuracy:0.7821
Epoch: 131, Validation loss: 1.1271, Best loss: 1.1271, Accuracy: 0.7821, Best Accuracy:0.7821
Epoch: 132, Validation loss: 1.1270, Best loss: 1.1270, Accuracy: 0.7821, Best Accuracy:0.7821
Epoch: 133, Validation loss: 1.1269, Best loss: 1.1269, Accuracy: 0.7826, Best Accuracy:0.7826
Epoch: 134, Validation loss: 1.1269, Best loss: 1.1269, Accuracy: 0.7838, Best Accuracy:0.7838
Epoch: 135, Validation loss: 1.1268, Best loss: 1.1268, Accuracy: 0.7838, Best Accuracy:0.7838
Epoch: 136, Validation loss: 1.1268, Best loss: 1.1268, Accuracy: 0.7846, Best Accuracy:0.7846
Epoch: 137, Validation loss: 1.1267, Best loss: 1.1267, Accuracy: 0.7846, Best Accuracy:0.7846
Epoch: 138, Validation loss: 1.1267, Best loss: 1.1267, Accuracy: 0.7846, Best Accuracy:0.7846
Epoch: 139, Validation loss: 1.1267, Best loss: 1.1267, Accuracy: 0.7850, Best Accuracy:0.7850
Epoch: 140, Validation loss: 1.1266, Best loss: 1.1266, Accuracy: 0.7850, Best Accuracy:0.7850
Epoch: 141, Validation loss: 1.1266, Best loss: 1.1266, Accuracy: 0.7850, Best Accuracy:0.7850
Epoch: 142, Validation loss: 1.1266, Best loss: 1.1266, Accuracy: 0.7854, Best Accuracy:0.7854
Epoch: 143, Validation loss: 1.1265, Best loss: 1.1266, Accuracy: 0.7850, Best Accuracy:0.7854
Epoch: 144, Validation loss: 1.1265, Best loss: 1.1265, Accuracy: 0.7858, Best Accuracy:0.7858
Epoch: 145, Validation loss: 1.1265, Best loss: 1.1265, Accuracy: 0.7862, Best Accuracy:0.7862
Epoch: 146, Validation loss: 1.1264, Best loss: 1.1264, Accuracy: 0.7875, Best Accuracy:0.7875
Epoch: 147, Validation loss: 1.1263, Best loss: 1.1263, Accuracy: 0.7887, Best Accuracy:0.7887
Epoch: 148, Validation loss: 1.1263, Best loss: 1.1263, Accuracy: 0.7895, Best Accuracy:0.7895
Epoch: 149, Validation loss: 1.1262, Best loss: 1.1262, Accuracy: 0.7907, Best Accuracy:0.7907
Epoch: 150, Validation loss: 1.1261, Best loss: 1.1261, Accuracy: 0.7907, Best Accuracy:0.7907
Epoch: 151, Validation loss: 1.1260, Best loss: 1.1260, Accuracy: 0.7907, Best Accuracy:0.7907
Epoch: 152, Validation loss: 1.1258, Best loss: 1.1260, Accuracy: 0.7903, Best Accuracy:0.7907
Epoch: 153, Validation loss: 1.1257, Best loss: 1.1260, Accuracy: 0.7903, Best Accuracy:0.7907
Epoch: 154, Validation loss: 1.1256, Best loss: 1.1256, Accuracy: 0.7912, Best Accuracy:0.7912
Epoch: 155, Validation loss: 1.1255, Best loss: 1.1256, Accuracy: 0.7903, Best Accuracy:0.7912
Epoch: 156, Validation loss: 1.1254, Best loss: 1.1254, Accuracy: 0.7912, Best Accuracy:0.7912
Epoch: 157, Validation loss: 1.1252, Best loss: 1.1254, Accuracy: 0.7907, Best Accuracy:0.7912
Epoch: 158, Validation loss: 1.1251, Best loss: 1.1254, Accuracy: 0.7907, Best Accuracy:0.7912
Epoch: 159, Validation loss: 1.1250, Best loss: 1.1254, Accuracy: 0.7907, Best Accuracy:0.7912
Epoch: 160, Validation loss: 1.1249, Best loss: 1.1254, Accuracy: 0.7903, Best Accuracy:0.7912
Epoch: 161, Validation loss: 1.1248, Best loss: 1.1254, Accuracy: 0.7903, Best Accuracy:0.7912
Epoch: 162, Validation loss: 1.1247, Best loss: 1.1254, Accuracy: 0.7899, Best Accuracy:0.7912
Epoch: 163, Validation loss: 1.1246, Best loss: 1.1254, Accuracy: 0.7899, Best Accuracy:0.7912
Epoch: 164, Validation loss: 1.1245, Best loss: 1.1245, Accuracy: 0.7912, Best Accuracy:0.7912
Epoch: 165, Validation loss: 1.1244, Best loss: 1.1244, Accuracy: 0.7916, Best Accuracy:0.7916
Epoch: 166, Validation loss: 1.1243, Best loss: 1.1244, Accuracy: 0.7912, Best Accuracy:0.7916
Epoch: 167, Validation loss: 1.1242, Best loss: 1.1244, Accuracy: 0.7912, Best Accuracy:0.7916
Epoch: 168, Validation loss: 1.1241, Best loss: 1.1244, Accuracy: 0.7912, Best Accuracy:0.7916
Epoch: 169, Validation loss: 1.1241, Best loss: 1.1244, Accuracy: 0.7903, Best Accuracy:0.7916
Epoch: 170, Validation loss: 1.1240, Best loss: 1.1244, Accuracy: 0.7907, Best Accuracy:0.7916
Epoch: 171, Validation loss: 1.1239, Best loss: 1.1244, Accuracy: 0.7912, Best Accuracy:0.7916
Epoch: 172, Validation loss: 1.1238, Best loss: 1.1244, Accuracy: 0.7912, Best Accuracy:0.7916
Epoch: 173, Validation loss: 1.1238, Best loss: 1.1238, Accuracy: 0.7916, Best Accuracy:0.7916
Epoch: 174, Validation loss: 1.1237, Best loss: 1.1237, Accuracy: 0.7916, Best Accuracy:0.7916
Epoch: 175, Validation loss: 1.1236, Best loss: 1.1236, Accuracy: 0.7916, Best Accuracy:0.7916
Epoch: 176, Validation loss: 1.1235, Best loss: 1.1236, Accuracy: 0.7912, Best Accuracy:0.7916
Epoch: 177, Validation loss: 1.1235, Best loss: 1.1236, Accuracy: 0.7912, Best Accuracy:0.7916
Epoch: 178, Validation loss: 1.1234, Best loss: 1.1236, Accuracy: 0.7903, Best Accuracy:0.7916
Epoch: 179, Validation loss: 1.1233, Best loss: 1.1236, Accuracy: 0.7903, Best Accuracy:0.7916
Epoch: 180, Validation loss: 1.1233, Best loss: 1.1236, Accuracy: 0.7903, Best Accuracy:0.7916
Epoch: 181, Validation loss: 1.1232, Best loss: 1.1236, Accuracy: 0.7907, Best Accuracy:0.7916
Epoch: 182, Validation loss: 1.1231, Best loss: 1.1236, Accuracy: 0.7907, Best Accuracy:0.7916
Epoch: 183, Validation loss: 1.1231, Best loss: 1.1236, Accuracy: 0.7903, Best Accuracy:0.7916
Epoch: 184, Validation loss: 1.1231, Best loss: 1.1236, Accuracy: 0.7899, Best Accuracy:0.7916
Epoch: 185, Validation loss: 1.1231, Best loss: 1.1236, Accuracy: 0.7903, Best Accuracy:0.7916
Epoch: 186, Validation loss: 1.1230, Best loss: 1.1236, Accuracy: 0.7903, Best Accuracy:0.7916
Epoch: 187, Validation loss: 1.1230, Best loss: 1.1236, Accuracy: 0.7895, Best Accuracy:0.7916
Epoch: 188, Validation loss: 1.1231, Best loss: 1.1236, Accuracy: 0.7895, Best Accuracy:0.7916
Epoch: 189, Validation loss: 1.1231, Best loss: 1.1236, Accuracy: 0.7895, Best Accuracy:0.7916
Epoch: 190, Validation loss: 1.1231, Best loss: 1.1236, Accuracy: 0.7891, Best Accuracy:0.7916
Epoch: 191, Validation loss: 1.1232, Best loss: 1.1236, Accuracy: 0.7891, Best Accuracy:0.7916
Epoch: 192, Validation loss: 1.1232, Best loss: 1.1236, Accuracy: 0.7883, Best Accuracy:0.7916
Epoch: 193, Validation loss: 1.1232, Best loss: 1.1236, Accuracy: 0.7883, Best Accuracy:0.7916
Epoch: 194, Validation loss: 1.1232, Best loss: 1.1236, Accuracy: 0.7887, Best Accuracy:0.7916
Epoch: 195, Validation loss: 1.1232, Best loss: 1.1236, Accuracy: 0.7887, Best Accuracy:0.7916
Epoch: 196, Validation loss: 1.1232, Best loss: 1.1236, Accuracy: 0.7891, Best Accuracy:0.7916
Epoch: 197, Validation loss: 1.1231, Best loss: 1.1236, Accuracy: 0.7891, Best Accuracy:0.7916
Epoch: 198, Validation loss: 1.1230, Best loss: 1.1236, Accuracy: 0.7891, Best Accuracy:0.7916
Epoch: 199, Validation loss: 1.1229, Best loss: 1.1236, Accuracy: 0.7887, Best Accuracy:0.7916
Epoch: 200, Validation loss: 1.1228, Best loss: 1.1236, Accuracy: 0.7887, Best Accuracy:0.7916
Epoch: 201, Validation loss: 1.1227, Best loss: 1.1236, Accuracy: 0.7887, Best Accuracy:0.7916
Epoch: 202, Validation loss: 1.1226, Best loss: 1.1236, Accuracy: 0.7891, Best Accuracy:0.7916
Epoch: 203, Validation loss: 1.1224, Best loss: 1.1236, Accuracy: 0.7891, Best Accuracy:0.7916
Epoch: 204, Validation loss: 1.1223, Best loss: 1.1236, Accuracy: 0.7891, Best Accuracy:0.7916
Epoch: 205, Validation loss: 1.1222, Best loss: 1.1236, Accuracy: 0.7899, Best Accuracy:0.7916
Epoch: 206, Validation loss: 1.1220, Best loss: 1.1236, Accuracy: 0.7895, Best Accuracy:0.7916
Early Stopping at epoch 206
Total training time: 15.3s
Final test accuracy: 0.7743
```