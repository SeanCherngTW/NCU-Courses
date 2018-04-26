# MNIST Cache Frozen Layer
Cache the top frozen layer (hidden layer 5) and observe the time training cost
## Summary
```
No cache: 8.1s
Cache with the same parameters: 3.0s
Cache with the same epoch (97): 5.4s
```
## Output
```
[learning_rate_0.9000, batch_size_50, early_stopping_30]
INFO:tensorflow:Restoring parameters from ./previous_model/final_model
Epoch:   1, Validation loss: 1.4969, Best loss: 1.4969, Accuracy: 0.3960, Best Accuracy:0.3960
Epoch:   2, Validation loss: 1.4433, Best loss: 1.4433, Accuracy: 0.4496, Best Accuracy:0.4496
Epoch:   3, Validation loss: 1.3565, Best loss: 1.3565, Accuracy: 0.5381, Best Accuracy:0.5381
Epoch:   4, Validation loss: 1.2893, Best loss: 1.2893, Accuracy: 0.6122, Best Accuracy:0.6122
Epoch:   5, Validation loss: 1.2485, Best loss: 1.2485, Accuracy: 0.6527, Best Accuracy:0.6527
Epoch:   6, Validation loss: 1.2274, Best loss: 1.2274, Accuracy: 0.6773, Best Accuracy:0.6773
Epoch:   7, Validation loss: 1.2107, Best loss: 1.2107, Accuracy: 0.6978, Best Accuracy:0.6978
Epoch:   8, Validation loss: 1.1979, Best loss: 1.1979, Accuracy: 0.7117, Best Accuracy:0.7117
Epoch:   9, Validation loss: 1.1890, Best loss: 1.1890, Accuracy: 0.7236, Best Accuracy:0.7236
Epoch:  10, Validation loss: 1.1839, Best loss: 1.1839, Accuracy: 0.7293, Best Accuracy:0.7293
Epoch:  11, Validation loss: 1.1818, Best loss: 1.1818, Accuracy: 0.7310, Best Accuracy:0.7310
Epoch:  12, Validation loss: 1.1807, Best loss: 1.1807, Accuracy: 0.7351, Best Accuracy:0.7351
Epoch:  13, Validation loss: 1.1803, Best loss: 1.1803, Accuracy: 0.7379, Best Accuracy:0.7379
Epoch:  14, Validation loss: 1.1802, Best loss: 1.1803, Accuracy: 0.7355, Best Accuracy:0.7379
Epoch:  15, Validation loss: 1.1803, Best loss: 1.1803, Accuracy: 0.7367, Best Accuracy:0.7379
Epoch:  16, Validation loss: 1.1803, Best loss: 1.1803, Accuracy: 0.7359, Best Accuracy:0.7379
Epoch:  17, Validation loss: 1.1800, Best loss: 1.1803, Accuracy: 0.7355, Best Accuracy:0.7379
Epoch:  18, Validation loss: 1.1795, Best loss: 1.1803, Accuracy: 0.7367, Best Accuracy:0.7379
Epoch:  19, Validation loss: 1.1792, Best loss: 1.1803, Accuracy: 0.7330, Best Accuracy:0.7379
Epoch:  20, Validation loss: 1.1792, Best loss: 1.1803, Accuracy: 0.7342, Best Accuracy:0.7379
Epoch:  21, Validation loss: 1.1792, Best loss: 1.1803, Accuracy: 0.7330, Best Accuracy:0.7379
Epoch:  22, Validation loss: 1.1793, Best loss: 1.1803, Accuracy: 0.7338, Best Accuracy:0.7379
Epoch:  23, Validation loss: 1.1796, Best loss: 1.1803, Accuracy: 0.7351, Best Accuracy:0.7379
Epoch:  24, Validation loss: 1.1798, Best loss: 1.1803, Accuracy: 0.7342, Best Accuracy:0.7379
Epoch:  25, Validation loss: 1.1801, Best loss: 1.1803, Accuracy: 0.7322, Best Accuracy:0.7379
Epoch:  26, Validation loss: 1.1804, Best loss: 1.1803, Accuracy: 0.7326, Best Accuracy:0.7379
Epoch:  27, Validation loss: 1.1807, Best loss: 1.1803, Accuracy: 0.7310, Best Accuracy:0.7379
Epoch:  28, Validation loss: 1.1810, Best loss: 1.1803, Accuracy: 0.7301, Best Accuracy:0.7379
Epoch:  29, Validation loss: 1.1815, Best loss: 1.1803, Accuracy: 0.7297, Best Accuracy:0.7379
Epoch:  30, Validation loss: 1.1820, Best loss: 1.1803, Accuracy: 0.7289, Best Accuracy:0.7379
Epoch:  31, Validation loss: 1.1827, Best loss: 1.1803, Accuracy: 0.7285, Best Accuracy:0.7379
Epoch:  32, Validation loss: 1.1836, Best loss: 1.1803, Accuracy: 0.7265, Best Accuracy:0.7379
Epoch:  33, Validation loss: 1.1846, Best loss: 1.1803, Accuracy: 0.7248, Best Accuracy:0.7379
Epoch:  34, Validation loss: 1.1855, Best loss: 1.1803, Accuracy: 0.7240, Best Accuracy:0.7379
Epoch:  35, Validation loss: 1.1862, Best loss: 1.1803, Accuracy: 0.7248, Best Accuracy:0.7379
Epoch:  36, Validation loss: 1.1867, Best loss: 1.1803, Accuracy: 0.7228, Best Accuracy:0.7379
Epoch:  37, Validation loss: 1.1871, Best loss: 1.1803, Accuracy: 0.7219, Best Accuracy:0.7379
Epoch:  38, Validation loss: 1.1874, Best loss: 1.1803, Accuracy: 0.7219, Best Accuracy:0.7379
Epoch:  39, Validation loss: 1.1876, Best loss: 1.1803, Accuracy: 0.7207, Best Accuracy:0.7379
Epoch:  40, Validation loss: 1.1877, Best loss: 1.1803, Accuracy: 0.7211, Best Accuracy:0.7379
Epoch:  41, Validation loss: 1.1876, Best loss: 1.1803, Accuracy: 0.7207, Best Accuracy:0.7379
Epoch:  42, Validation loss: 1.1875, Best loss: 1.1803, Accuracy: 0.7203, Best Accuracy:0.7379
Epoch:  43, Validation loss: 1.1873, Best loss: 1.1803, Accuracy: 0.7191, Best Accuracy:0.7379
Epoch:  44, Validation loss: 1.1871, Best loss: 1.1803, Accuracy: 0.7191, Best Accuracy:0.7379
Early Stopping at epoch 44
Total training time: 3.0s
Final test accuracy: 0.7027
```
```
[learning_rate_0.9000, batch_size_50, early_stopping_1000]
INFO:tensorflow:Restoring parameters from ./previous_model/final_model
Epoch:   1, Validation loss: 1.4969, Best loss: 1.4969, Accuracy: 0.3960, Best Accuracy:0.3960
Epoch:   2, Validation loss: 1.4433, Best loss: 1.4433, Accuracy: 0.4496, Best Accuracy:0.4496
Epoch:   3, Validation loss: 1.3565, Best loss: 1.3565, Accuracy: 0.5381, Best Accuracy:0.5381
Epoch:   4, Validation loss: 1.2893, Best loss: 1.2893, Accuracy: 0.6122, Best Accuracy:0.6122
Epoch:   5, Validation loss: 1.2485, Best loss: 1.2485, Accuracy: 0.6527, Best Accuracy:0.6527
Epoch:   6, Validation loss: 1.2274, Best loss: 1.2274, Accuracy: 0.6773, Best Accuracy:0.6773
Epoch:   7, Validation loss: 1.2107, Best loss: 1.2107, Accuracy: 0.6978, Best Accuracy:0.6978
Epoch:   8, Validation loss: 1.1979, Best loss: 1.1979, Accuracy: 0.7117, Best Accuracy:0.7117
Epoch:   9, Validation loss: 1.1890, Best loss: 1.1890, Accuracy: 0.7236, Best Accuracy:0.7236
Epoch:  10, Validation loss: 1.1839, Best loss: 1.1839, Accuracy: 0.7293, Best Accuracy:0.7293
Epoch:  11, Validation loss: 1.1818, Best loss: 1.1818, Accuracy: 0.7310, Best Accuracy:0.7310
Epoch:  12, Validation loss: 1.1807, Best loss: 1.1807, Accuracy: 0.7351, Best Accuracy:0.7351
Epoch:  13, Validation loss: 1.1803, Best loss: 1.1803, Accuracy: 0.7379, Best Accuracy:0.7379
Epoch:  14, Validation loss: 1.1802, Best loss: 1.1803, Accuracy: 0.7355, Best Accuracy:0.7379
Epoch:  15, Validation loss: 1.1803, Best loss: 1.1803, Accuracy: 0.7367, Best Accuracy:0.7379
Epoch:  16, Validation loss: 1.1803, Best loss: 1.1803, Accuracy: 0.7359, Best Accuracy:0.7379
Epoch:  17, Validation loss: 1.1800, Best loss: 1.1803, Accuracy: 0.7355, Best Accuracy:0.7379
Epoch:  18, Validation loss: 1.1795, Best loss: 1.1803, Accuracy: 0.7367, Best Accuracy:0.7379
Epoch:  19, Validation loss: 1.1792, Best loss: 1.1803, Accuracy: 0.7330, Best Accuracy:0.7379
Epoch:  20, Validation loss: 1.1792, Best loss: 1.1803, Accuracy: 0.7342, Best Accuracy:0.7379
Epoch:  21, Validation loss: 1.1792, Best loss: 1.1803, Accuracy: 0.7330, Best Accuracy:0.7379
Epoch:  22, Validation loss: 1.1793, Best loss: 1.1803, Accuracy: 0.7338, Best Accuracy:0.7379
Epoch:  23, Validation loss: 1.1796, Best loss: 1.1803, Accuracy: 0.7351, Best Accuracy:0.7379
Epoch:  24, Validation loss: 1.1798, Best loss: 1.1803, Accuracy: 0.7342, Best Accuracy:0.7379
Epoch:  25, Validation loss: 1.1801, Best loss: 1.1803, Accuracy: 0.7322, Best Accuracy:0.7379
Epoch:  26, Validation loss: 1.1804, Best loss: 1.1803, Accuracy: 0.7326, Best Accuracy:0.7379
Epoch:  27, Validation loss: 1.1807, Best loss: 1.1803, Accuracy: 0.7310, Best Accuracy:0.7379
Epoch:  28, Validation loss: 1.1810, Best loss: 1.1803, Accuracy: 0.7301, Best Accuracy:0.7379
Epoch:  29, Validation loss: 1.1815, Best loss: 1.1803, Accuracy: 0.7297, Best Accuracy:0.7379
Epoch:  30, Validation loss: 1.1820, Best loss: 1.1803, Accuracy: 0.7289, Best Accuracy:0.7379
Epoch:  31, Validation loss: 1.1827, Best loss: 1.1803, Accuracy: 0.7285, Best Accuracy:0.7379
Epoch:  32, Validation loss: 1.1836, Best loss: 1.1803, Accuracy: 0.7265, Best Accuracy:0.7379
Epoch:  33, Validation loss: 1.1846, Best loss: 1.1803, Accuracy: 0.7248, Best Accuracy:0.7379
Epoch:  34, Validation loss: 1.1855, Best loss: 1.1803, Accuracy: 0.7240, Best Accuracy:0.7379
Epoch:  35, Validation loss: 1.1862, Best loss: 1.1803, Accuracy: 0.7248, Best Accuracy:0.7379
Epoch:  36, Validation loss: 1.1867, Best loss: 1.1803, Accuracy: 0.7228, Best Accuracy:0.7379
Epoch:  37, Validation loss: 1.1871, Best loss: 1.1803, Accuracy: 0.7219, Best Accuracy:0.7379
Epoch:  38, Validation loss: 1.1874, Best loss: 1.1803, Accuracy: 0.7219, Best Accuracy:0.7379
Epoch:  39, Validation loss: 1.1876, Best loss: 1.1803, Accuracy: 0.7207, Best Accuracy:0.7379
Epoch:  40, Validation loss: 1.1877, Best loss: 1.1803, Accuracy: 0.7211, Best Accuracy:0.7379
Epoch:  41, Validation loss: 1.1876, Best loss: 1.1803, Accuracy: 0.7207, Best Accuracy:0.7379
Epoch:  42, Validation loss: 1.1875, Best loss: 1.1803, Accuracy: 0.7203, Best Accuracy:0.7379
Epoch:  43, Validation loss: 1.1873, Best loss: 1.1803, Accuracy: 0.7191, Best Accuracy:0.7379
Epoch:  44, Validation loss: 1.1871, Best loss: 1.1803, Accuracy: 0.7191, Best Accuracy:0.7379
Epoch:  45, Validation loss: 1.1869, Best loss: 1.1803, Accuracy: 0.7203, Best Accuracy:0.7379
Epoch:  46, Validation loss: 1.1866, Best loss: 1.1803, Accuracy: 0.7215, Best Accuracy:0.7379
Epoch:  47, Validation loss: 1.1863, Best loss: 1.1803, Accuracy: 0.7219, Best Accuracy:0.7379
Epoch:  48, Validation loss: 1.1861, Best loss: 1.1803, Accuracy: 0.7224, Best Accuracy:0.7379
Epoch:  49, Validation loss: 1.1858, Best loss: 1.1803, Accuracy: 0.7224, Best Accuracy:0.7379
Epoch:  50, Validation loss: 1.1856, Best loss: 1.1803, Accuracy: 0.7232, Best Accuracy:0.7379
Epoch:  51, Validation loss: 1.1854, Best loss: 1.1803, Accuracy: 0.7228, Best Accuracy:0.7379
Epoch:  52, Validation loss: 1.1851, Best loss: 1.1803, Accuracy: 0.7224, Best Accuracy:0.7379
Epoch:  53, Validation loss: 1.1850, Best loss: 1.1803, Accuracy: 0.7228, Best Accuracy:0.7379
Epoch:  54, Validation loss: 1.1848, Best loss: 1.1803, Accuracy: 0.7228, Best Accuracy:0.7379
Epoch:  55, Validation loss: 1.1846, Best loss: 1.1803, Accuracy: 0.7232, Best Accuracy:0.7379
Epoch:  56, Validation loss: 1.1844, Best loss: 1.1803, Accuracy: 0.7224, Best Accuracy:0.7379
Epoch:  57, Validation loss: 1.1843, Best loss: 1.1803, Accuracy: 0.7224, Best Accuracy:0.7379
Epoch:  58, Validation loss: 1.1842, Best loss: 1.1803, Accuracy: 0.7232, Best Accuracy:0.7379
Epoch:  59, Validation loss: 1.1841, Best loss: 1.1803, Accuracy: 0.7236, Best Accuracy:0.7379
Epoch:  60, Validation loss: 1.1840, Best loss: 1.1803, Accuracy: 0.7228, Best Accuracy:0.7379
Epoch:  61, Validation loss: 1.1839, Best loss: 1.1803, Accuracy: 0.7232, Best Accuracy:0.7379
Epoch:  62, Validation loss: 1.1839, Best loss: 1.1803, Accuracy: 0.7228, Best Accuracy:0.7379
Epoch:  63, Validation loss: 1.1838, Best loss: 1.1803, Accuracy: 0.7224, Best Accuracy:0.7379
Epoch:  64, Validation loss: 1.1838, Best loss: 1.1803, Accuracy: 0.7215, Best Accuracy:0.7379
Epoch:  65, Validation loss: 1.1839, Best loss: 1.1803, Accuracy: 0.7207, Best Accuracy:0.7379
Epoch:  66, Validation loss: 1.1840, Best loss: 1.1803, Accuracy: 0.7207, Best Accuracy:0.7379
Epoch:  67, Validation loss: 1.1840, Best loss: 1.1803, Accuracy: 0.7203, Best Accuracy:0.7379
Epoch:  68, Validation loss: 1.1841, Best loss: 1.1803, Accuracy: 0.7199, Best Accuracy:0.7379
Epoch:  69, Validation loss: 1.1841, Best loss: 1.1803, Accuracy: 0.7203, Best Accuracy:0.7379
Epoch:  70, Validation loss: 1.1841, Best loss: 1.1803, Accuracy: 0.7207, Best Accuracy:0.7379
Epoch:  71, Validation loss: 1.1840, Best loss: 1.1803, Accuracy: 0.7211, Best Accuracy:0.7379
Epoch:  72, Validation loss: 1.1839, Best loss: 1.1803, Accuracy: 0.7219, Best Accuracy:0.7379
Epoch:  73, Validation loss: 1.1838, Best loss: 1.1803, Accuracy: 0.7207, Best Accuracy:0.7379
Epoch:  74, Validation loss: 1.1837, Best loss: 1.1803, Accuracy: 0.7207, Best Accuracy:0.7379
Epoch:  75, Validation loss: 1.1836, Best loss: 1.1803, Accuracy: 0.7211, Best Accuracy:0.7379
Epoch:  76, Validation loss: 1.1835, Best loss: 1.1803, Accuracy: 0.7211, Best Accuracy:0.7379
Epoch:  77, Validation loss: 1.1834, Best loss: 1.1803, Accuracy: 0.7211, Best Accuracy:0.7379
Epoch:  78, Validation loss: 1.1833, Best loss: 1.1803, Accuracy: 0.7219, Best Accuracy:0.7379
Epoch:  79, Validation loss: 1.1832, Best loss: 1.1803, Accuracy: 0.7224, Best Accuracy:0.7379
Epoch:  80, Validation loss: 1.1831, Best loss: 1.1803, Accuracy: 0.7224, Best Accuracy:0.7379
Epoch:  81, Validation loss: 1.1830, Best loss: 1.1803, Accuracy: 0.7219, Best Accuracy:0.7379
Epoch:  82, Validation loss: 1.1829, Best loss: 1.1803, Accuracy: 0.7224, Best Accuracy:0.7379
Epoch:  83, Validation loss: 1.1829, Best loss: 1.1803, Accuracy: 0.7219, Best Accuracy:0.7379
Epoch:  84, Validation loss: 1.1828, Best loss: 1.1803, Accuracy: 0.7224, Best Accuracy:0.7379
Epoch:  85, Validation loss: 1.1827, Best loss: 1.1803, Accuracy: 0.7228, Best Accuracy:0.7379
Epoch:  86, Validation loss: 1.1827, Best loss: 1.1803, Accuracy: 0.7228, Best Accuracy:0.7379
Epoch:  87, Validation loss: 1.1826, Best loss: 1.1803, Accuracy: 0.7232, Best Accuracy:0.7379
Epoch:  88, Validation loss: 1.1826, Best loss: 1.1803, Accuracy: 0.7244, Best Accuracy:0.7379
Epoch:  89, Validation loss: 1.1826, Best loss: 1.1803, Accuracy: 0.7244, Best Accuracy:0.7379
Epoch:  90, Validation loss: 1.1827, Best loss: 1.1803, Accuracy: 0.7248, Best Accuracy:0.7379
Epoch:  91, Validation loss: 1.1828, Best loss: 1.1803, Accuracy: 0.7244, Best Accuracy:0.7379
Epoch:  92, Validation loss: 1.1827, Best loss: 1.1803, Accuracy: 0.7244, Best Accuracy:0.7379
Epoch:  93, Validation loss: 1.1826, Best loss: 1.1803, Accuracy: 0.7232, Best Accuracy:0.7379
Epoch:  94, Validation loss: 1.1824, Best loss: 1.1803, Accuracy: 0.7240, Best Accuracy:0.7379
Epoch:  95, Validation loss: 1.1822, Best loss: 1.1803, Accuracy: 0.7248, Best Accuracy:0.7379
Epoch:  96, Validation loss: 1.1821, Best loss: 1.1803, Accuracy: 0.7252, Best Accuracy:0.7379
Epoch:  97, Validation loss: 1.1820, Best loss: 1.1803, Accuracy: 0.7256, Best Accuracy:0.7379
Total training time: 5.4s
Final test accuracy: 0.7083
```