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
test accuracy: 0.7488
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
[n_neurons_100, learning_rate_0.1000, activation_<function relu at 0x11536a6a8>, batch_size_100, batch_normalization_True]
INFO:tensorflow:Restoring parameters from ./previous_model/final_model.ckpt
Epoch:   1, Validation loss: 1.5522, Best loss: 1.5522, Accuracy: 0.3346, Best Accuracy:0.3346
Epoch:   2, Validation loss: 1.5501, Best loss: 1.5501, Accuracy: 0.3370, Best Accuracy:0.3370
Epoch:   3, Validation loss: 1.5479, Best loss: 1.5479, Accuracy: 0.3395, Best Accuracy:0.3395
Epoch:   4, Validation loss: 1.5457, Best loss: 1.5457, Accuracy: 0.3436, Best Accuracy:0.3436
Epoch:   5, Validation loss: 1.5435, Best loss: 1.5435, Accuracy: 0.3468, Best Accuracy:0.3468
Epoch:   6, Validation loss: 1.5413, Best loss: 1.5413, Accuracy: 0.3501, Best Accuracy:0.3501
Epoch:   7, Validation loss: 1.5391, Best loss: 1.5391, Accuracy: 0.3509, Best Accuracy:0.3509
Epoch:   8, Validation loss: 1.5368, Best loss: 1.5368, Accuracy: 0.3526, Best Accuracy:0.3526
Epoch:   9, Validation loss: 1.5345, Best loss: 1.5345, Accuracy: 0.3550, Best Accuracy:0.3550
Epoch:  10, Validation loss: 1.5322, Best loss: 1.5322, Accuracy: 0.3567, Best Accuracy:0.3567
Epoch:  11, Validation loss: 1.5299, Best loss: 1.5299, Accuracy: 0.3595, Best Accuracy:0.3595
Epoch:  12, Validation loss: 1.5276, Best loss: 1.5276, Accuracy: 0.3616, Best Accuracy:0.3616
Epoch:  13, Validation loss: 1.5253, Best loss: 1.5253, Accuracy: 0.3640, Best Accuracy:0.3640
Epoch:  14, Validation loss: 1.5229, Best loss: 1.5229, Accuracy: 0.3657, Best Accuracy:0.3657
Epoch:  15, Validation loss: 1.5205, Best loss: 1.5205, Accuracy: 0.3677, Best Accuracy:0.3677
Epoch:  16, Validation loss: 1.5181, Best loss: 1.5181, Accuracy: 0.3706, Best Accuracy:0.3706
Epoch:  17, Validation loss: 1.5157, Best loss: 1.5157, Accuracy: 0.3739, Best Accuracy:0.3739
Epoch:  18, Validation loss: 1.5132, Best loss: 1.5132, Accuracy: 0.3763, Best Accuracy:0.3763
Epoch:  19, Validation loss: 1.5107, Best loss: 1.5107, Accuracy: 0.3792, Best Accuracy:0.3792
Epoch:  20, Validation loss: 1.5081, Best loss: 1.5081, Accuracy: 0.3808, Best Accuracy:0.3808
Epoch:  21, Validation loss: 1.5055, Best loss: 1.5055, Accuracy: 0.3829, Best Accuracy:0.3829
Epoch:  22, Validation loss: 1.5029, Best loss: 1.5029, Accuracy: 0.3845, Best Accuracy:0.3845
Epoch:  23, Validation loss: 1.5002, Best loss: 1.5002, Accuracy: 0.3853, Best Accuracy:0.3853
Epoch:  24, Validation loss: 1.4974, Best loss: 1.4974, Accuracy: 0.3874, Best Accuracy:0.3874
Epoch:  25, Validation loss: 1.4946, Best loss: 1.4946, Accuracy: 0.3915, Best Accuracy:0.3915
Epoch:  26, Validation loss: 1.4917, Best loss: 1.4917, Accuracy: 0.3931, Best Accuracy:0.3931
Epoch:  27, Validation loss: 1.4888, Best loss: 1.4888, Accuracy: 0.3964, Best Accuracy:0.3964
Epoch:  28, Validation loss: 1.4858, Best loss: 1.4858, Accuracy: 0.3997, Best Accuracy:0.3997
Epoch:  29, Validation loss: 1.4828, Best loss: 1.4828, Accuracy: 0.4038, Best Accuracy:0.4038
Epoch:  30, Validation loss: 1.4797, Best loss: 1.4797, Accuracy: 0.4062, Best Accuracy:0.4062
Epoch:  31, Validation loss: 1.4766, Best loss: 1.4766, Accuracy: 0.4095, Best Accuracy:0.4095
Epoch:  32, Validation loss: 1.4733, Best loss: 1.4733, Accuracy: 0.4132, Best Accuracy:0.4132
Epoch:  33, Validation loss: 1.4700, Best loss: 1.4700, Accuracy: 0.4152, Best Accuracy:0.4152
Epoch:  34, Validation loss: 1.4667, Best loss: 1.4667, Accuracy: 0.4193, Best Accuracy:0.4193
Epoch:  35, Validation loss: 1.4632, Best loss: 1.4632, Accuracy: 0.4255, Best Accuracy:0.4255
Epoch:  36, Validation loss: 1.4597, Best loss: 1.4597, Accuracy: 0.4292, Best Accuracy:0.4292
Epoch:  37, Validation loss: 1.4562, Best loss: 1.4562, Accuracy: 0.4333, Best Accuracy:0.4333
Epoch:  38, Validation loss: 1.4525, Best loss: 1.4525, Accuracy: 0.4386, Best Accuracy:0.4386
Epoch:  39, Validation loss: 1.4488, Best loss: 1.4488, Accuracy: 0.4447, Best Accuracy:0.4447
Epoch:  40, Validation loss: 1.4450, Best loss: 1.4450, Accuracy: 0.4488, Best Accuracy:0.4488
Epoch:  41, Validation loss: 1.4411, Best loss: 1.4411, Accuracy: 0.4537, Best Accuracy:0.4537
Epoch:  42, Validation loss: 1.4371, Best loss: 1.4371, Accuracy: 0.4566, Best Accuracy:0.4566
Epoch:  43, Validation loss: 1.4330, Best loss: 1.4330, Accuracy: 0.4627, Best Accuracy:0.4627
Epoch:  44, Validation loss: 1.4287, Best loss: 1.4287, Accuracy: 0.4652, Best Accuracy:0.4652
Epoch:  45, Validation loss: 1.4244, Best loss: 1.4244, Accuracy: 0.4701, Best Accuracy:0.4701
Epoch:  46, Validation loss: 1.4200, Best loss: 1.4200, Accuracy: 0.4754, Best Accuracy:0.4754
Epoch:  47, Validation loss: 1.4155, Best loss: 1.4155, Accuracy: 0.4824, Best Accuracy:0.4824
Epoch:  48, Validation loss: 1.4109, Best loss: 1.4109, Accuracy: 0.4873, Best Accuracy:0.4873
Epoch:  49, Validation loss: 1.4062, Best loss: 1.4062, Accuracy: 0.4894, Best Accuracy:0.4894
Epoch:  50, Validation loss: 1.4013, Best loss: 1.4013, Accuracy: 0.4930, Best Accuracy:0.4930
Epoch:  51, Validation loss: 1.3963, Best loss: 1.3963, Accuracy: 0.4975, Best Accuracy:0.4975
Epoch:  52, Validation loss: 1.3910, Best loss: 1.3910, Accuracy: 0.5049, Best Accuracy:0.5049
Epoch:  53, Validation loss: 1.3856, Best loss: 1.3856, Accuracy: 0.5123, Best Accuracy:0.5123
Epoch:  54, Validation loss: 1.3801, Best loss: 1.3801, Accuracy: 0.5168, Best Accuracy:0.5168
Epoch:  55, Validation loss: 1.3743, Best loss: 1.3743, Accuracy: 0.5242, Best Accuracy:0.5242
Epoch:  56, Validation loss: 1.3684, Best loss: 1.3684, Accuracy: 0.5283, Best Accuracy:0.5283
Epoch:  57, Validation loss: 1.3625, Best loss: 1.3625, Accuracy: 0.5385, Best Accuracy:0.5385
Epoch:  58, Validation loss: 1.3567, Best loss: 1.3567, Accuracy: 0.5434, Best Accuracy:0.5434
Epoch:  59, Validation loss: 1.3509, Best loss: 1.3509, Accuracy: 0.5487, Best Accuracy:0.5487
Epoch:  60, Validation loss: 1.3452, Best loss: 1.3452, Accuracy: 0.5532, Best Accuracy:0.5532
Epoch:  61, Validation loss: 1.3396, Best loss: 1.3396, Accuracy: 0.5622, Best Accuracy:0.5622
Epoch:  62, Validation loss: 1.3343, Best loss: 1.3343, Accuracy: 0.5688, Best Accuracy:0.5688
Epoch:  63, Validation loss: 1.3291, Best loss: 1.3291, Accuracy: 0.5725, Best Accuracy:0.5725
Epoch:  64, Validation loss: 1.3240, Best loss: 1.3240, Accuracy: 0.5790, Best Accuracy:0.5790
Epoch:  65, Validation loss: 1.3192, Best loss: 1.3192, Accuracy: 0.5831, Best Accuracy:0.5831
Epoch:  66, Validation loss: 1.3144, Best loss: 1.3144, Accuracy: 0.5880, Best Accuracy:0.5880
Epoch:  67, Validation loss: 1.3097, Best loss: 1.3097, Accuracy: 0.5958, Best Accuracy:0.5958
Epoch:  68, Validation loss: 1.3051, Best loss: 1.3051, Accuracy: 0.5991, Best Accuracy:0.5991
Epoch:  69, Validation loss: 1.3005, Best loss: 1.3005, Accuracy: 0.6048, Best Accuracy:0.6048
Epoch:  70, Validation loss: 1.2959, Best loss: 1.2959, Accuracy: 0.6114, Best Accuracy:0.6114
Epoch:  71, Validation loss: 1.2912, Best loss: 1.2912, Accuracy: 0.6183, Best Accuracy:0.6183
Epoch:  72, Validation loss: 1.2864, Best loss: 1.2864, Accuracy: 0.6220, Best Accuracy:0.6220
Epoch:  73, Validation loss: 1.2814, Best loss: 1.2814, Accuracy: 0.6282, Best Accuracy:0.6282
Epoch:  74, Validation loss: 1.2760, Best loss: 1.2760, Accuracy: 0.6327, Best Accuracy:0.6327
Epoch:  75, Validation loss: 1.2703, Best loss: 1.2703, Accuracy: 0.6413, Best Accuracy:0.6413
Epoch:  76, Validation loss: 1.2642, Best loss: 1.2642, Accuracy: 0.6466, Best Accuracy:0.6466
Epoch:  77, Validation loss: 1.2581, Best loss: 1.2581, Accuracy: 0.6536, Best Accuracy:0.6536
Epoch:  78, Validation loss: 1.2525, Best loss: 1.2525, Accuracy: 0.6618, Best Accuracy:0.6618
Epoch:  79, Validation loss: 1.2478, Best loss: 1.2478, Accuracy: 0.6712, Best Accuracy:0.6712
Epoch:  80, Validation loss: 1.2439, Best loss: 1.2439, Accuracy: 0.6757, Best Accuracy:0.6757
Epoch:  81, Validation loss: 1.2408, Best loss: 1.2408, Accuracy: 0.6798, Best Accuracy:0.6798
Epoch:  82, Validation loss: 1.2381, Best loss: 1.2381, Accuracy: 0.6810, Best Accuracy:0.6810
Epoch:  83, Validation loss: 1.2358, Best loss: 1.2358, Accuracy: 0.6822, Best Accuracy:0.6822
Epoch:  84, Validation loss: 1.2337, Best loss: 1.2337, Accuracy: 0.6843, Best Accuracy:0.6843
Epoch:  85, Validation loss: 1.2318, Best loss: 1.2318, Accuracy: 0.6871, Best Accuracy:0.6871
Epoch:  86, Validation loss: 1.2301, Best loss: 1.2301, Accuracy: 0.6904, Best Accuracy:0.6904
Epoch:  87, Validation loss: 1.2285, Best loss: 1.2285, Accuracy: 0.6933, Best Accuracy:0.6933
Epoch:  88, Validation loss: 1.2269, Best loss: 1.2269, Accuracy: 0.6941, Best Accuracy:0.6941
Epoch:  89, Validation loss: 1.2255, Best loss: 1.2255, Accuracy: 0.6957, Best Accuracy:0.6957
Epoch:  90, Validation loss: 1.2241, Best loss: 1.2241, Accuracy: 0.6966, Best Accuracy:0.6966
Epoch:  91, Validation loss: 1.2227, Best loss: 1.2227, Accuracy: 0.6978, Best Accuracy:0.6978
Epoch:  92, Validation loss: 1.2214, Best loss: 1.2214, Accuracy: 0.6998, Best Accuracy:0.6998
Epoch:  93, Validation loss: 1.2201, Best loss: 1.2214, Accuracy: 0.6994, Best Accuracy:0.6998
Epoch:  94, Validation loss: 1.2189, Best loss: 1.2189, Accuracy: 0.7015, Best Accuracy:0.7015
Epoch:  95, Validation loss: 1.2176, Best loss: 1.2176, Accuracy: 0.7015, Best Accuracy:0.7015
Epoch:  96, Validation loss: 1.2164, Best loss: 1.2176, Accuracy: 0.7011, Best Accuracy:0.7015
Epoch:  97, Validation loss: 1.2152, Best loss: 1.2152, Accuracy: 0.7023, Best Accuracy:0.7023
Epoch:  98, Validation loss: 1.2140, Best loss: 1.2140, Accuracy: 0.7039, Best Accuracy:0.7039
Epoch:  99, Validation loss: 1.2128, Best loss: 1.2128, Accuracy: 0.7056, Best Accuracy:0.7056
Epoch: 100, Validation loss: 1.2117, Best loss: 1.2117, Accuracy: 0.7060, Best Accuracy:0.7060
Epoch: 101, Validation loss: 1.2105, Best loss: 1.2105, Accuracy: 0.7068, Best Accuracy:0.7068
Epoch: 102, Validation loss: 1.2094, Best loss: 1.2094, Accuracy: 0.7084, Best Accuracy:0.7084
Epoch: 103, Validation loss: 1.2082, Best loss: 1.2082, Accuracy: 0.7101, Best Accuracy:0.7101
Epoch: 104, Validation loss: 1.2071, Best loss: 1.2071, Accuracy: 0.7109, Best Accuracy:0.7109
Epoch: 105, Validation loss: 1.2060, Best loss: 1.2060, Accuracy: 0.7109, Best Accuracy:0.7109
Epoch: 106, Validation loss: 1.2049, Best loss: 1.2049, Accuracy: 0.7121, Best Accuracy:0.7121
Epoch: 107, Validation loss: 1.2038, Best loss: 1.2038, Accuracy: 0.7154, Best Accuracy:0.7154
Epoch: 108, Validation loss: 1.2028, Best loss: 1.2028, Accuracy: 0.7162, Best Accuracy:0.7162
Epoch: 109, Validation loss: 1.2018, Best loss: 1.2018, Accuracy: 0.7179, Best Accuracy:0.7179
Epoch: 110, Validation loss: 1.2008, Best loss: 1.2008, Accuracy: 0.7199, Best Accuracy:0.7199
Epoch: 111, Validation loss: 1.1998, Best loss: 1.2008, Accuracy: 0.7195, Best Accuracy:0.7199
Epoch: 112, Validation loss: 1.1988, Best loss: 1.1988, Accuracy: 0.7211, Best Accuracy:0.7211
Epoch: 113, Validation loss: 1.1979, Best loss: 1.1988, Accuracy: 0.7207, Best Accuracy:0.7211
Epoch: 114, Validation loss: 1.1970, Best loss: 1.1970, Accuracy: 0.7211, Best Accuracy:0.7211
Epoch: 115, Validation loss: 1.1961, Best loss: 1.1961, Accuracy: 0.7215, Best Accuracy:0.7215
Epoch: 116, Validation loss: 1.1953, Best loss: 1.1953, Accuracy: 0.7228, Best Accuracy:0.7228
Epoch: 117, Validation loss: 1.1945, Best loss: 1.1945, Accuracy: 0.7228, Best Accuracy:0.7228
Epoch: 118, Validation loss: 1.1937, Best loss: 1.1937, Accuracy: 0.7236, Best Accuracy:0.7236
Epoch: 119, Validation loss: 1.1929, Best loss: 1.1929, Accuracy: 0.7236, Best Accuracy:0.7236
Epoch: 120, Validation loss: 1.1922, Best loss: 1.1929, Accuracy: 0.7228, Best Accuracy:0.7236
Epoch: 121, Validation loss: 1.1915, Best loss: 1.1915, Accuracy: 0.7244, Best Accuracy:0.7244
Epoch: 122, Validation loss: 1.1908, Best loss: 1.1908, Accuracy: 0.7248, Best Accuracy:0.7248
Epoch: 123, Validation loss: 1.1901, Best loss: 1.1901, Accuracy: 0.7260, Best Accuracy:0.7260
Epoch: 124, Validation loss: 1.1895, Best loss: 1.1895, Accuracy: 0.7297, Best Accuracy:0.7297
Epoch: 125, Validation loss: 1.1889, Best loss: 1.1889, Accuracy: 0.7301, Best Accuracy:0.7301
Epoch: 126, Validation loss: 1.1882, Best loss: 1.1882, Accuracy: 0.7310, Best Accuracy:0.7310
Epoch: 127, Validation loss: 1.1877, Best loss: 1.1882, Accuracy: 0.7305, Best Accuracy:0.7310
Epoch: 128, Validation loss: 1.1871, Best loss: 1.1882, Accuracy: 0.7301, Best Accuracy:0.7310
Epoch: 129, Validation loss: 1.1865, Best loss: 1.1865, Accuracy: 0.7318, Best Accuracy:0.7318
Epoch: 130, Validation loss: 1.1860, Best loss: 1.1860, Accuracy: 0.7322, Best Accuracy:0.7322
Epoch: 131, Validation loss: 1.1854, Best loss: 1.1854, Accuracy: 0.7322, Best Accuracy:0.7322
Epoch: 132, Validation loss: 1.1849, Best loss: 1.1849, Accuracy: 0.7330, Best Accuracy:0.7330
Epoch: 133, Validation loss: 1.1844, Best loss: 1.1844, Accuracy: 0.7346, Best Accuracy:0.7346
Epoch: 134, Validation loss: 1.1839, Best loss: 1.1844, Accuracy: 0.7342, Best Accuracy:0.7346
Epoch: 135, Validation loss: 1.1834, Best loss: 1.1834, Accuracy: 0.7351, Best Accuracy:0.7351
Epoch: 136, Validation loss: 1.1829, Best loss: 1.1829, Accuracy: 0.7355, Best Accuracy:0.7355
Epoch: 137, Validation loss: 1.1824, Best loss: 1.1824, Accuracy: 0.7367, Best Accuracy:0.7367
Epoch: 138, Validation loss: 1.1820, Best loss: 1.1820, Accuracy: 0.7371, Best Accuracy:0.7371
Epoch: 139, Validation loss: 1.1815, Best loss: 1.1820, Accuracy: 0.7367, Best Accuracy:0.7371
Epoch: 140, Validation loss: 1.1811, Best loss: 1.1811, Accuracy: 0.7379, Best Accuracy:0.7379
Epoch: 141, Validation loss: 1.1806, Best loss: 1.1806, Accuracy: 0.7391, Best Accuracy:0.7391
Epoch: 142, Validation loss: 1.1802, Best loss: 1.1806, Accuracy: 0.7387, Best Accuracy:0.7391
Epoch: 143, Validation loss: 1.1798, Best loss: 1.1798, Accuracy: 0.7391, Best Accuracy:0.7391
Epoch: 144, Validation loss: 1.1794, Best loss: 1.1794, Accuracy: 0.7412, Best Accuracy:0.7412
Epoch: 145, Validation loss: 1.1789, Best loss: 1.1794, Accuracy: 0.7408, Best Accuracy:0.7412
Epoch: 146, Validation loss: 1.1785, Best loss: 1.1794, Accuracy: 0.7408, Best Accuracy:0.7412
Epoch: 147, Validation loss: 1.1781, Best loss: 1.1781, Accuracy: 0.7416, Best Accuracy:0.7416
Epoch: 148, Validation loss: 1.1777, Best loss: 1.1777, Accuracy: 0.7424, Best Accuracy:0.7424
Epoch: 149, Validation loss: 1.1773, Best loss: 1.1773, Accuracy: 0.7428, Best Accuracy:0.7428
Epoch: 150, Validation loss: 1.1769, Best loss: 1.1769, Accuracy: 0.7437, Best Accuracy:0.7437
Epoch: 151, Validation loss: 1.1765, Best loss: 1.1765, Accuracy: 0.7445, Best Accuracy:0.7445
Epoch: 152, Validation loss: 1.1761, Best loss: 1.1761, Accuracy: 0.7449, Best Accuracy:0.7449
Epoch: 153, Validation loss: 1.1757, Best loss: 1.1757, Accuracy: 0.7469, Best Accuracy:0.7469
Epoch: 154, Validation loss: 1.1753, Best loss: 1.1753, Accuracy: 0.7477, Best Accuracy:0.7477
Epoch: 155, Validation loss: 1.1749, Best loss: 1.1753, Accuracy: 0.7473, Best Accuracy:0.7477
Epoch: 156, Validation loss: 1.1745, Best loss: 1.1753, Accuracy: 0.7469, Best Accuracy:0.7477
Epoch: 157, Validation loss: 1.1741, Best loss: 1.1741, Accuracy: 0.7477, Best Accuracy:0.7477
Epoch: 158, Validation loss: 1.1737, Best loss: 1.1737, Accuracy: 0.7498, Best Accuracy:0.7498
Epoch: 159, Validation loss: 1.1734, Best loss: 1.1734, Accuracy: 0.7510, Best Accuracy:0.7510
Epoch: 160, Validation loss: 1.1730, Best loss: 1.1730, Accuracy: 0.7527, Best Accuracy:0.7527
Epoch: 161, Validation loss: 1.1726, Best loss: 1.1726, Accuracy: 0.7535, Best Accuracy:0.7535
Epoch: 162, Validation loss: 1.1722, Best loss: 1.1722, Accuracy: 0.7539, Best Accuracy:0.7539
Epoch: 163, Validation loss: 1.1718, Best loss: 1.1718, Accuracy: 0.7539, Best Accuracy:0.7539
Epoch: 164, Validation loss: 1.1714, Best loss: 1.1714, Accuracy: 0.7539, Best Accuracy:0.7539
Epoch: 165, Validation loss: 1.1711, Best loss: 1.1714, Accuracy: 0.7531, Best Accuracy:0.7539
Epoch: 166, Validation loss: 1.1707, Best loss: 1.1714, Accuracy: 0.7523, Best Accuracy:0.7539
Epoch: 167, Validation loss: 1.1704, Best loss: 1.1714, Accuracy: 0.7531, Best Accuracy:0.7539
Epoch: 168, Validation loss: 1.1700, Best loss: 1.1714, Accuracy: 0.7535, Best Accuracy:0.7539
Epoch: 169, Validation loss: 1.1697, Best loss: 1.1697, Accuracy: 0.7539, Best Accuracy:0.7539
Epoch: 170, Validation loss: 1.1694, Best loss: 1.1697, Accuracy: 0.7531, Best Accuracy:0.7539
Epoch: 171, Validation loss: 1.1691, Best loss: 1.1691, Accuracy: 0.7547, Best Accuracy:0.7547
Epoch: 172, Validation loss: 1.1688, Best loss: 1.1688, Accuracy: 0.7551, Best Accuracy:0.7551
Epoch: 173, Validation loss: 1.1686, Best loss: 1.1686, Accuracy: 0.7559, Best Accuracy:0.7559
Epoch: 174, Validation loss: 1.1683, Best loss: 1.1686, Accuracy: 0.7555, Best Accuracy:0.7559
Epoch: 175, Validation loss: 1.1681, Best loss: 1.1686, Accuracy: 0.7551, Best Accuracy:0.7559
Epoch: 176, Validation loss: 1.1679, Best loss: 1.1686, Accuracy: 0.7547, Best Accuracy:0.7559
Epoch: 177, Validation loss: 1.1677, Best loss: 1.1686, Accuracy: 0.7547, Best Accuracy:0.7559
Epoch: 178, Validation loss: 1.1676, Best loss: 1.1686, Accuracy: 0.7555, Best Accuracy:0.7559
Epoch: 179, Validation loss: 1.1674, Best loss: 1.1674, Accuracy: 0.7568, Best Accuracy:0.7568
Epoch: 180, Validation loss: 1.1672, Best loss: 1.1672, Accuracy: 0.7572, Best Accuracy:0.7572
Epoch: 181, Validation loss: 1.1671, Best loss: 1.1672, Accuracy: 0.7568, Best Accuracy:0.7572
Epoch: 182, Validation loss: 1.1669, Best loss: 1.1672, Accuracy: 0.7563, Best Accuracy:0.7572
Epoch: 183, Validation loss: 1.1668, Best loss: 1.1668, Accuracy: 0.7572, Best Accuracy:0.7572
Epoch: 184, Validation loss: 1.1666, Best loss: 1.1666, Accuracy: 0.7572, Best Accuracy:0.7572
Epoch: 185, Validation loss: 1.1664, Best loss: 1.1664, Accuracy: 0.7576, Best Accuracy:0.7576
Epoch: 186, Validation loss: 1.1663, Best loss: 1.1663, Accuracy: 0.7580, Best Accuracy:0.7580
Epoch: 187, Validation loss: 1.1661, Best loss: 1.1661, Accuracy: 0.7588, Best Accuracy:0.7588
Epoch: 188, Validation loss: 1.1660, Best loss: 1.1660, Accuracy: 0.7592, Best Accuracy:0.7592
Epoch: 189, Validation loss: 1.1659, Best loss: 1.1659, Accuracy: 0.7596, Best Accuracy:0.7596
Epoch: 190, Validation loss: 1.1657, Best loss: 1.1657, Accuracy: 0.7604, Best Accuracy:0.7604
Epoch: 191, Validation loss: 1.1656, Best loss: 1.1656, Accuracy: 0.7604, Best Accuracy:0.7604
Epoch: 192, Validation loss: 1.1654, Best loss: 1.1656, Accuracy: 0.7596, Best Accuracy:0.7604
Epoch: 193, Validation loss: 1.1653, Best loss: 1.1656, Accuracy: 0.7592, Best Accuracy:0.7604
Epoch: 194, Validation loss: 1.1652, Best loss: 1.1656, Accuracy: 0.7596, Best Accuracy:0.7604
Epoch: 195, Validation loss: 1.1650, Best loss: 1.1656, Accuracy: 0.7588, Best Accuracy:0.7604
Epoch: 196, Validation loss: 1.1649, Best loss: 1.1656, Accuracy: 0.7580, Best Accuracy:0.7604
Epoch: 197, Validation loss: 1.1648, Best loss: 1.1656, Accuracy: 0.7588, Best Accuracy:0.7604
Epoch: 198, Validation loss: 1.1646, Best loss: 1.1656, Accuracy: 0.7584, Best Accuracy:0.7604
Epoch: 199, Validation loss: 1.1645, Best loss: 1.1656, Accuracy: 0.7588, Best Accuracy:0.7604
Epoch: 200, Validation loss: 1.1644, Best loss: 1.1656, Accuracy: 0.7588, Best Accuracy:0.7604
Epoch: 201, Validation loss: 1.1643, Best loss: 1.1656, Accuracy: 0.7588, Best Accuracy:0.7604
Epoch: 202, Validation loss: 1.1642, Best loss: 1.1656, Accuracy: 0.7592, Best Accuracy:0.7604
Epoch: 203, Validation loss: 1.1640, Best loss: 1.1656, Accuracy: 0.7588, Best Accuracy:0.7604
Epoch: 204, Validation loss: 1.1639, Best loss: 1.1656, Accuracy: 0.7584, Best Accuracy:0.7604
Epoch: 205, Validation loss: 1.1638, Best loss: 1.1656, Accuracy: 0.7584, Best Accuracy:0.7604
Epoch: 206, Validation loss: 1.1637, Best loss: 1.1656, Accuracy: 0.7584, Best Accuracy:0.7604
Epoch: 207, Validation loss: 1.1636, Best loss: 1.1656, Accuracy: 0.7592, Best Accuracy:0.7604
Epoch: 208, Validation loss: 1.1635, Best loss: 1.1656, Accuracy: 0.7588, Best Accuracy:0.7604
Epoch: 209, Validation loss: 1.1634, Best loss: 1.1656, Accuracy: 0.7580, Best Accuracy:0.7604
Epoch: 210, Validation loss: 1.1633, Best loss: 1.1656, Accuracy: 0.7572, Best Accuracy:0.7604
Epoch: 211, Validation loss: 1.1632, Best loss: 1.1656, Accuracy: 0.7572, Best Accuracy:0.7604
Epoch: 212, Validation loss: 1.1632, Best loss: 1.1656, Accuracy: 0.7576, Best Accuracy:0.7604
Epoch: 213, Validation loss: 1.1631, Best loss: 1.1656, Accuracy: 0.7576, Best Accuracy:0.7604
Epoch: 214, Validation loss: 1.1630, Best loss: 1.1656, Accuracy: 0.7568, Best Accuracy:0.7604
Epoch: 215, Validation loss: 1.1629, Best loss: 1.1656, Accuracy: 0.7563, Best Accuracy:0.7604
Epoch: 216, Validation loss: 1.1628, Best loss: 1.1656, Accuracy: 0.7555, Best Accuracy:0.7604
Epoch: 217, Validation loss: 1.1628, Best loss: 1.1656, Accuracy: 0.7555, Best Accuracy:0.7604
Epoch: 218, Validation loss: 1.1627, Best loss: 1.1656, Accuracy: 0.7559, Best Accuracy:0.7604
Epoch: 219, Validation loss: 1.1626, Best loss: 1.1656, Accuracy: 0.7555, Best Accuracy:0.7604
Epoch: 220, Validation loss: 1.1626, Best loss: 1.1656, Accuracy: 0.7551, Best Accuracy:0.7604
Epoch: 221, Validation loss: 1.1625, Best loss: 1.1656, Accuracy: 0.7555, Best Accuracy:0.7604
Epoch: 222, Validation loss: 1.1625, Best loss: 1.1656, Accuracy: 0.7547, Best Accuracy:0.7604
Early Stopping at epoch 222
Total training time: 15.6s
Final test accuracy: 0.7488
```