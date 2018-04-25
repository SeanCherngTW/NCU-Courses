# MNIST Transfer Learning
Restore the model from 1E and train MNIST data 5-9 (100 images per digit)
Using the concept of transfer learning to evaluate the performance

freeze: hidden_layer_1 to hidden_layer_5
trainable: output_layer

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
Epoch:   1, Validation loss: 1.2125, Best loss: 1.2125, Accuracy: 0.6933, Best Accuracy:0.6933
Epoch:   2, Validation loss: 1.1967, Best loss: 1.1967, Accuracy: 0.7064, Best Accuracy:0.7064
Epoch:   3, Validation loss: 1.1779, Best loss: 1.1779, Accuracy: 0.7269, Best Accuracy:0.7269
Epoch:   4, Validation loss: 1.1772, Best loss: 1.1779, Accuracy: 0.7219, Best Accuracy:0.7269
Epoch:   5, Validation loss: 1.1740, Best loss: 1.1740, Accuracy: 0.7277, Best Accuracy:0.7277
Epoch:   6, Validation loss: 1.1634, Best loss: 1.1634, Accuracy: 0.7408, Best Accuracy:0.7408
Epoch:   7, Validation loss: 1.1595, Best loss: 1.1595, Accuracy: 0.7408, Best Accuracy:0.7408
Epoch:   8, Validation loss: 1.1585, Best loss: 1.1585, Accuracy: 0.7445, Best Accuracy:0.7445
Epoch:   9, Validation loss: 1.1552, Best loss: 1.1552, Accuracy: 0.7461, Best Accuracy:0.7461
Epoch:  10, Validation loss: 1.1532, Best loss: 1.1532, Accuracy: 0.7498, Best Accuracy:0.7498
Epoch:  11, Validation loss: 1.1507, Best loss: 1.1532, Accuracy: 0.7486, Best Accuracy:0.7498
Epoch:  12, Validation loss: 1.1487, Best loss: 1.1487, Accuracy: 0.7514, Best Accuracy:0.7514
Epoch:  13, Validation loss: 1.1460, Best loss: 1.1460, Accuracy: 0.7563, Best Accuracy:0.7563
Epoch:  14, Validation loss: 1.1458, Best loss: 1.1458, Accuracy: 0.7563, Best Accuracy:0.7563
Epoch:  15, Validation loss: 1.1444, Best loss: 1.1444, Accuracy: 0.7572, Best Accuracy:0.7572
Epoch:  16, Validation loss: 1.1458, Best loss: 1.1458, Accuracy: 0.7580, Best Accuracy:0.7580
Epoch:  17, Validation loss: 1.1478, Best loss: 1.1478, Accuracy: 0.7580, Best Accuracy:0.7580
Epoch:  18, Validation loss: 1.1506, Best loss: 1.1478, Accuracy: 0.7510, Best Accuracy:0.7580
Epoch:  19, Validation loss: 1.1480, Best loss: 1.1478, Accuracy: 0.7551, Best Accuracy:0.7580
Epoch:  20, Validation loss: 1.1551, Best loss: 1.1478, Accuracy: 0.7453, Best Accuracy:0.7580
Epoch:  21, Validation loss: 1.1558, Best loss: 1.1478, Accuracy: 0.7445, Best Accuracy:0.7580
Epoch:  22, Validation loss: 1.1517, Best loss: 1.1478, Accuracy: 0.7514, Best Accuracy:0.7580
Epoch:  23, Validation loss: 1.1491, Best loss: 1.1478, Accuracy: 0.7539, Best Accuracy:0.7580
Epoch:  24, Validation loss: 1.1485, Best loss: 1.1478, Accuracy: 0.7539, Best Accuracy:0.7580
Epoch:  25, Validation loss: 1.1481, Best loss: 1.1478, Accuracy: 0.7563, Best Accuracy:0.7580
Epoch:  26, Validation loss: 1.1478, Best loss: 1.1478, Accuracy: 0.7559, Best Accuracy:0.7580
Epoch:  27, Validation loss: 1.1475, Best loss: 1.1478, Accuracy: 0.7559, Best Accuracy:0.7580
Epoch:  28, Validation loss: 1.1473, Best loss: 1.1478, Accuracy: 0.7576, Best Accuracy:0.7580
Epoch:  29, Validation loss: 1.1471, Best loss: 1.1478, Accuracy: 0.7576, Best Accuracy:0.7580
Epoch:  30, Validation loss: 1.1469, Best loss: 1.1469, Accuracy: 0.7580, Best Accuracy:0.7580
Epoch:  31, Validation loss: 1.1467, Best loss: 1.1467, Accuracy: 0.7592, Best Accuracy:0.7592
Epoch:  32, Validation loss: 1.1466, Best loss: 1.1467, Accuracy: 0.7580, Best Accuracy:0.7592
Epoch:  33, Validation loss: 1.1464, Best loss: 1.1467, Accuracy: 0.7580, Best Accuracy:0.7592
Epoch:  34, Validation loss: 1.1462, Best loss: 1.1467, Accuracy: 0.7572, Best Accuracy:0.7592
Epoch:  35, Validation loss: 1.1461, Best loss: 1.1467, Accuracy: 0.7584, Best Accuracy:0.7592
Epoch:  36, Validation loss: 1.1459, Best loss: 1.1467, Accuracy: 0.7588, Best Accuracy:0.7592
Epoch:  37, Validation loss: 1.1457, Best loss: 1.1467, Accuracy: 0.7580, Best Accuracy:0.7592
Epoch:  38, Validation loss: 1.1456, Best loss: 1.1467, Accuracy: 0.7563, Best Accuracy:0.7592
Epoch:  39, Validation loss: 1.1457, Best loss: 1.1467, Accuracy: 0.7563, Best Accuracy:0.7592
Epoch:  40, Validation loss: 1.1456, Best loss: 1.1467, Accuracy: 0.7551, Best Accuracy:0.7592
Epoch:  41, Validation loss: 1.1457, Best loss: 1.1467, Accuracy: 0.7559, Best Accuracy:0.7592
Epoch:  42, Validation loss: 1.1456, Best loss: 1.1467, Accuracy: 0.7563, Best Accuracy:0.7592
Epoch:  43, Validation loss: 1.1453, Best loss: 1.1467, Accuracy: 0.7563, Best Accuracy:0.7592
Epoch:  44, Validation loss: 1.1447, Best loss: 1.1467, Accuracy: 0.7572, Best Accuracy:0.7592
Epoch:  45, Validation loss: 1.1433, Best loss: 1.1433, Accuracy: 0.7596, Best Accuracy:0.7596
Epoch:  46, Validation loss: 1.1431, Best loss: 1.1433, Accuracy: 0.7588, Best Accuracy:0.7596
Epoch:  47, Validation loss: 1.1428, Best loss: 1.1428, Accuracy: 0.7596, Best Accuracy:0.7596
Epoch:  48, Validation loss: 1.1426, Best loss: 1.1428, Accuracy: 0.7592, Best Accuracy:0.7596
Epoch:  49, Validation loss: 1.1430, Best loss: 1.1428, Accuracy: 0.7588, Best Accuracy:0.7596
Epoch:  50, Validation loss: 1.1423, Best loss: 1.1428, Accuracy: 0.7588, Best Accuracy:0.7596
Epoch:  51, Validation loss: 1.1423, Best loss: 1.1428, Accuracy: 0.7588, Best Accuracy:0.7596
Epoch:  52, Validation loss: 1.1423, Best loss: 1.1423, Accuracy: 0.7600, Best Accuracy:0.7600
Epoch:  53, Validation loss: 1.1425, Best loss: 1.1425, Accuracy: 0.7600, Best Accuracy:0.7600
Epoch:  54, Validation loss: 1.1425, Best loss: 1.1425, Accuracy: 0.7592, Best Accuracy:0.7600
Epoch:  55, Validation loss: 1.1424, Best loss: 1.1425, Accuracy: 0.7592, Best Accuracy:0.7600
Epoch:  56, Validation loss: 1.1423, Best loss: 1.1425, Accuracy: 0.7588, Best Accuracy:0.7600
Epoch:  57, Validation loss: 1.1421, Best loss: 1.1425, Accuracy: 0.7584, Best Accuracy:0.7600
Epoch:  58, Validation loss: 1.1420, Best loss: 1.1425, Accuracy: 0.7588, Best Accuracy:0.7600
Epoch:  59, Validation loss: 1.1419, Best loss: 1.1425, Accuracy: 0.7596, Best Accuracy:0.7600
Epoch:  60, Validation loss: 1.1417, Best loss: 1.1417, Accuracy: 0.7609, Best Accuracy:0.7609
Epoch:  61, Validation loss: 1.1418, Best loss: 1.1417, Accuracy: 0.7600, Best Accuracy:0.7609
Epoch:  62, Validation loss: 1.1426, Best loss: 1.1417, Accuracy: 0.7580, Best Accuracy:0.7609
Epoch:  63, Validation loss: 1.1422, Best loss: 1.1417, Accuracy: 0.7580, Best Accuracy:0.7609
Epoch:  64, Validation loss: 1.1415, Best loss: 1.1415, Accuracy: 0.7613, Best Accuracy:0.7613
Epoch:  65, Validation loss: 1.1414, Best loss: 1.1414, Accuracy: 0.7613, Best Accuracy:0.7613
Epoch:  66, Validation loss: 1.1414, Best loss: 1.1414, Accuracy: 0.7621, Best Accuracy:0.7621
Epoch:  67, Validation loss: 1.1414, Best loss: 1.1414, Accuracy: 0.7613, Best Accuracy:0.7621
Epoch:  68, Validation loss: 1.1414, Best loss: 1.1414, Accuracy: 0.7613, Best Accuracy:0.7621
Epoch:  69, Validation loss: 1.1414, Best loss: 1.1414, Accuracy: 0.7613, Best Accuracy:0.7621
Epoch:  70, Validation loss: 1.1414, Best loss: 1.1414, Accuracy: 0.7617, Best Accuracy:0.7621
Epoch:  71, Validation loss: 1.1415, Best loss: 1.1414, Accuracy: 0.7613, Best Accuracy:0.7621
Epoch:  72, Validation loss: 1.1415, Best loss: 1.1414, Accuracy: 0.7613, Best Accuracy:0.7621
Epoch:  73, Validation loss: 1.1415, Best loss: 1.1414, Accuracy: 0.7609, Best Accuracy:0.7621
Epoch:  74, Validation loss: 1.1415, Best loss: 1.1414, Accuracy: 0.7609, Best Accuracy:0.7621
Epoch:  75, Validation loss: 1.1416, Best loss: 1.1414, Accuracy: 0.7613, Best Accuracy:0.7621
Epoch:  76, Validation loss: 1.1417, Best loss: 1.1414, Accuracy: 0.7613, Best Accuracy:0.7621
Epoch:  77, Validation loss: 1.1418, Best loss: 1.1414, Accuracy: 0.7617, Best Accuracy:0.7621
Epoch:  78, Validation loss: 1.1418, Best loss: 1.1414, Accuracy: 0.7613, Best Accuracy:0.7621
Epoch:  79, Validation loss: 1.1419, Best loss: 1.1414, Accuracy: 0.7613, Best Accuracy:0.7621
Epoch:  80, Validation loss: 1.1421, Best loss: 1.1414, Accuracy: 0.7609, Best Accuracy:0.7621
Epoch:  81, Validation loss: 1.1422, Best loss: 1.1414, Accuracy: 0.7604, Best Accuracy:0.7621
Epoch:  82, Validation loss: 1.1423, Best loss: 1.1414, Accuracy: 0.7600, Best Accuracy:0.7621
Epoch:  83, Validation loss: 1.1423, Best loss: 1.1414, Accuracy: 0.7600, Best Accuracy:0.7621
Epoch:  84, Validation loss: 1.1424, Best loss: 1.1414, Accuracy: 0.7604, Best Accuracy:0.7621
Epoch:  85, Validation loss: 1.1424, Best loss: 1.1414, Accuracy: 0.7604, Best Accuracy:0.7621
Epoch:  86, Validation loss: 1.1425, Best loss: 1.1414, Accuracy: 0.7604, Best Accuracy:0.7621
Epoch:  87, Validation loss: 1.1425, Best loss: 1.1414, Accuracy: 0.7604, Best Accuracy:0.7621
Epoch:  88, Validation loss: 1.1426, Best loss: 1.1414, Accuracy: 0.7600, Best Accuracy:0.7621
Epoch:  89, Validation loss: 1.1426, Best loss: 1.1414, Accuracy: 0.7596, Best Accuracy:0.7621
Epoch:  90, Validation loss: 1.1427, Best loss: 1.1414, Accuracy: 0.7600, Best Accuracy:0.7621
Epoch:  91, Validation loss: 1.1428, Best loss: 1.1414, Accuracy: 0.7600, Best Accuracy:0.7621
Epoch:  92, Validation loss: 1.1429, Best loss: 1.1414, Accuracy: 0.7596, Best Accuracy:0.7621
Epoch:  93, Validation loss: 1.1430, Best loss: 1.1414, Accuracy: 0.7592, Best Accuracy:0.7621
Epoch:  94, Validation loss: 1.1432, Best loss: 1.1414, Accuracy: 0.7592, Best Accuracy:0.7621
Epoch:  95, Validation loss: 1.1435, Best loss: 1.1414, Accuracy: 0.7596, Best Accuracy:0.7621
Epoch:  96, Validation loss: 1.1439, Best loss: 1.1414, Accuracy: 0.7580, Best Accuracy:0.7621
Epoch:  97, Validation loss: 1.1454, Best loss: 1.1414, Accuracy: 0.7555, Best Accuracy:0.7621
Early Stopping at epoch 97
Total training time: 8.1s
Final test accuracy: 0.7422
```