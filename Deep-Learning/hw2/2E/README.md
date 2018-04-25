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
Epoch:   1, Validation loss: 1.2102, Best loss: 1.2102, Accuracy: 0.6908, Best Accuracy:0.6908
Epoch:   2, Validation loss: 1.1836, Best loss: 1.1836, Accuracy: 0.7150, Best Accuracy:0.7150
Epoch:   3, Validation loss: 1.1864, Best loss: 1.1836, Accuracy: 0.7142, Best Accuracy:0.7150
Epoch:   4, Validation loss: 1.1344, Best loss: 1.1344, Accuracy: 0.7662, Best Accuracy:0.7662
Epoch:   5, Validation loss: 1.1234, Best loss: 1.1234, Accuracy: 0.7789, Best Accuracy:0.7789
Epoch:   6, Validation loss: 1.0960, Best loss: 1.0960, Accuracy: 0.8038, Best Accuracy:0.8038
Epoch:   7, Validation loss: 1.0932, Best loss: 1.0932, Accuracy: 0.8079, Best Accuracy:0.8079
Epoch:   8, Validation loss: 1.0878, Best loss: 1.0878, Accuracy: 0.8149, Best Accuracy:0.8149
Epoch:   9, Validation loss: 1.0735, Best loss: 1.0735, Accuracy: 0.8284, Best Accuracy:0.8284
Epoch:  10, Validation loss: 1.0631, Best loss: 1.0631, Accuracy: 0.8387, Best Accuracy:0.8387
Epoch:  11, Validation loss: 1.0737, Best loss: 1.0631, Accuracy: 0.8296, Best Accuracy:0.8387
Epoch:  12, Validation loss: 1.0794, Best loss: 1.0631, Accuracy: 0.8219, Best Accuracy:0.8387
Epoch:  13, Validation loss: 1.0703, Best loss: 1.0631, Accuracy: 0.8301, Best Accuracy:0.8387
Epoch:  14, Validation loss: 1.0768, Best loss: 1.0631, Accuracy: 0.8268, Best Accuracy:0.8387
Epoch:  15, Validation loss: 1.0715, Best loss: 1.0631, Accuracy: 0.8313, Best Accuracy:0.8387
Epoch:  16, Validation loss: 1.0606, Best loss: 1.0606, Accuracy: 0.8407, Best Accuracy:0.8407
Epoch:  17, Validation loss: 1.0850, Best loss: 1.0606, Accuracy: 0.8165, Best Accuracy:0.8407
Epoch:  18, Validation loss: 1.0677, Best loss: 1.0606, Accuracy: 0.8337, Best Accuracy:0.8407
Epoch:  19, Validation loss: 1.0592, Best loss: 1.0592, Accuracy: 0.8428, Best Accuracy:0.8428
Epoch:  20, Validation loss: 1.0634, Best loss: 1.0592, Accuracy: 0.8399, Best Accuracy:0.8428
Epoch:  21, Validation loss: 1.0663, Best loss: 1.0592, Accuracy: 0.8370, Best Accuracy:0.8428
Epoch:  22, Validation loss: 1.0642, Best loss: 1.0592, Accuracy: 0.8391, Best Accuracy:0.8428
Epoch:  23, Validation loss: 1.0675, Best loss: 1.0592, Accuracy: 0.8358, Best Accuracy:0.8428
Epoch:  24, Validation loss: 1.0648, Best loss: 1.0592, Accuracy: 0.8378, Best Accuracy:0.8428
Epoch:  25, Validation loss: 1.0643, Best loss: 1.0592, Accuracy: 0.8399, Best Accuracy:0.8428
Epoch:  26, Validation loss: 1.0641, Best loss: 1.0592, Accuracy: 0.8395, Best Accuracy:0.8428
Epoch:  27, Validation loss: 1.0641, Best loss: 1.0592, Accuracy: 0.8399, Best Accuracy:0.8428
Epoch:  28, Validation loss: 1.0638, Best loss: 1.0592, Accuracy: 0.8382, Best Accuracy:0.8428
Epoch:  29, Validation loss: 1.0632, Best loss: 1.0592, Accuracy: 0.8395, Best Accuracy:0.8428
Epoch:  30, Validation loss: 1.0626, Best loss: 1.0592, Accuracy: 0.8391, Best Accuracy:0.8428
Epoch:  31, Validation loss: 1.0635, Best loss: 1.0592, Accuracy: 0.8370, Best Accuracy:0.8428
Epoch:  32, Validation loss: 1.0631, Best loss: 1.0592, Accuracy: 0.8391, Best Accuracy:0.8428
Epoch:  33, Validation loss: 1.0621, Best loss: 1.0592, Accuracy: 0.8415, Best Accuracy:0.8428
Epoch:  34, Validation loss: 1.0628, Best loss: 1.0592, Accuracy: 0.8403, Best Accuracy:0.8428
Epoch:  35, Validation loss: 1.0629, Best loss: 1.0592, Accuracy: 0.8395, Best Accuracy:0.8428
Epoch:  36, Validation loss: 1.0618, Best loss: 1.0592, Accuracy: 0.8411, Best Accuracy:0.8428
Epoch:  37, Validation loss: 1.0617, Best loss: 1.0592, Accuracy: 0.8411, Best Accuracy:0.8428
Epoch:  38, Validation loss: 1.0617, Best loss: 1.0592, Accuracy: 0.8407, Best Accuracy:0.8428
Epoch:  39, Validation loss: 1.0624, Best loss: 1.0592, Accuracy: 0.8407, Best Accuracy:0.8428
Epoch:  40, Validation loss: 1.0619, Best loss: 1.0592, Accuracy: 0.8411, Best Accuracy:0.8428
Epoch:  41, Validation loss: 1.0615, Best loss: 1.0592, Accuracy: 0.8419, Best Accuracy:0.8428
Epoch:  42, Validation loss: 1.0609, Best loss: 1.0592, Accuracy: 0.8415, Best Accuracy:0.8428
Epoch:  43, Validation loss: 1.0613, Best loss: 1.0592, Accuracy: 0.8423, Best Accuracy:0.8428
Epoch:  44, Validation loss: 1.0616, Best loss: 1.0616, Accuracy: 0.8428, Best Accuracy:0.8428
Epoch:  45, Validation loss: 1.0620, Best loss: 1.0616, Accuracy: 0.8423, Best Accuracy:0.8428
Epoch:  46, Validation loss: 1.0598, Best loss: 1.0598, Accuracy: 0.8440, Best Accuracy:0.8440
Epoch:  47, Validation loss: 1.0583, Best loss: 1.0583, Accuracy: 0.8468, Best Accuracy:0.8468
Epoch:  48, Validation loss: 1.0585, Best loss: 1.0583, Accuracy: 0.8460, Best Accuracy:0.8468
Epoch:  49, Validation loss: 1.0576, Best loss: 1.0583, Accuracy: 0.8464, Best Accuracy:0.8468
Epoch:  50, Validation loss: 1.0580, Best loss: 1.0583, Accuracy: 0.8460, Best Accuracy:0.8468
Epoch:  51, Validation loss: 1.0576, Best loss: 1.0583, Accuracy: 0.8460, Best Accuracy:0.8468
Epoch:  52, Validation loss: 1.0582, Best loss: 1.0583, Accuracy: 0.8448, Best Accuracy:0.8468
Epoch:  53, Validation loss: 1.0588, Best loss: 1.0583, Accuracy: 0.8460, Best Accuracy:0.8468
Epoch:  54, Validation loss: 1.0581, Best loss: 1.0581, Accuracy: 0.8481, Best Accuracy:0.8481
Epoch:  55, Validation loss: 1.0586, Best loss: 1.0581, Accuracy: 0.8460, Best Accuracy:0.8481
Epoch:  56, Validation loss: 1.0584, Best loss: 1.0581, Accuracy: 0.8464, Best Accuracy:0.8481
Epoch:  57, Validation loss: 1.0571, Best loss: 1.0581, Accuracy: 0.8468, Best Accuracy:0.8481
Epoch:  58, Validation loss: 1.0574, Best loss: 1.0581, Accuracy: 0.8477, Best Accuracy:0.8481
Epoch:  59, Validation loss: 1.0566, Best loss: 1.0566, Accuracy: 0.8489, Best Accuracy:0.8489
Epoch:  60, Validation loss: 1.0567, Best loss: 1.0566, Accuracy: 0.8485, Best Accuracy:0.8489
Epoch:  61, Validation loss: 1.0562, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  62, Validation loss: 1.0579, Best loss: 1.0566, Accuracy: 0.8473, Best Accuracy:0.8489
Epoch:  63, Validation loss: 1.0579, Best loss: 1.0566, Accuracy: 0.8464, Best Accuracy:0.8489
Epoch:  64, Validation loss: 1.0557, Best loss: 1.0566, Accuracy: 0.8481, Best Accuracy:0.8489
Epoch:  65, Validation loss: 1.0573, Best loss: 1.0566, Accuracy: 0.8464, Best Accuracy:0.8489
Epoch:  66, Validation loss: 1.0559, Best loss: 1.0566, Accuracy: 0.8468, Best Accuracy:0.8489
Epoch:  67, Validation loss: 1.0559, Best loss: 1.0566, Accuracy: 0.8481, Best Accuracy:0.8489
Epoch:  68, Validation loss: 1.0564, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  69, Validation loss: 1.0554, Best loss: 1.0566, Accuracy: 0.8485, Best Accuracy:0.8489
Epoch:  70, Validation loss: 1.0574, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  71, Validation loss: 1.0571, Best loss: 1.0566, Accuracy: 0.8460, Best Accuracy:0.8489
Epoch:  72, Validation loss: 1.0573, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  73, Validation loss: 1.0552, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  74, Validation loss: 1.0563, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  75, Validation loss: 1.0577, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  76, Validation loss: 1.0582, Best loss: 1.0566, Accuracy: 0.8452, Best Accuracy:0.8489
Epoch:  77, Validation loss: 1.0572, Best loss: 1.0566, Accuracy: 0.8473, Best Accuracy:0.8489
Epoch:  78, Validation loss: 1.0564, Best loss: 1.0566, Accuracy: 0.8468, Best Accuracy:0.8489
Epoch:  79, Validation loss: 1.0574, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  80, Validation loss: 1.0553, Best loss: 1.0566, Accuracy: 0.8473, Best Accuracy:0.8489
Epoch:  81, Validation loss: 1.0576, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  82, Validation loss: 1.0563, Best loss: 1.0566, Accuracy: 0.8464, Best Accuracy:0.8489
Epoch:  83, Validation loss: 1.0568, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  84, Validation loss: 1.0557, Best loss: 1.0566, Accuracy: 0.8468, Best Accuracy:0.8489
Epoch:  85, Validation loss: 1.0560, Best loss: 1.0566, Accuracy: 0.8464, Best Accuracy:0.8489
Epoch:  86, Validation loss: 1.0562, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  87, Validation loss: 1.0574, Best loss: 1.0566, Accuracy: 0.8468, Best Accuracy:0.8489
Epoch:  88, Validation loss: 1.0565, Best loss: 1.0566, Accuracy: 0.8477, Best Accuracy:0.8489
Epoch:  89, Validation loss: 1.0546, Best loss: 1.0566, Accuracy: 0.8481, Best Accuracy:0.8489
Epoch:  90, Validation loss: 1.0554, Best loss: 1.0566, Accuracy: 0.8473, Best Accuracy:0.8489
Early Stopping at epoch 90
Total training time: 7.8s
Final test accuracy: 0.8348
```