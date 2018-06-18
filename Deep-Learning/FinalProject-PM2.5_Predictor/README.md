# PM2.5 Predictor

## Overview
Train 5 epochs
Train data: 台中市西屯區 (Roughly 200,000 data)
Valid data: 台南市中西區 (Roughly 100,000 data)

## CASE1
- Train: Delete zero data and outliers
- Valid: Delete zero data and outliers
- Problem: 在預測201703資料時會出問題，因為201703包含很多zero data, outliers
```
(neurons, batchsize, trainloss, validloss)
(50 , 100, 0.9820, 1.5122) -> best
(128, 100, 0.9670, 2.9163)
(256, 100, 1.0068, 7.9966)
(512, 100, 1.0320, 9.5747)
(50 , 200, 3.2446, 5.0226)
(128, 200, 1.4070, 9.5506)
(256, 200, 1.3481, 12.8201)
(512, 200, 1684.1396, 2174.7403) -> broken
(50 , 300, 8.5651, 13.0937)
(128, 300, 2.7768, 11.7962)
(256, 300, 1.9288, 13.4616)
(512, 300, 1.5933, 11.8608)
```

## CASE2
- Train: Delete outliers
- Valid: Delete outliers
- Problem: 在預測201703資料時會出問題，因為201703包含很多outliers
```
(neurons, batchsize, trainloss, validloss)
(50, 100, 15.4034, 16.3235)
```

## CASE3
- Train: Delete zero data and outliers
- Valid: Special normalization 
    - 最大值定在```mean+2*std```, 最小值訂在```mean-2*std```，再做```(x-min)/(max-min)```所以標準化後，outliers的值會小於0和大於1
- With feature "Date", "Time"
    ```
    (neurons, batchsize, trainloss, validloss)
    (50, 100, 0.9875, 23.9823)
    ```
- Without feature "Date", "Time"
    ```
    (neurons, batchsize, trainloss, validloss)
    (50, 100, 17.2458, 56.7963)
    ```

## CASE4
- Train: Special normalization 
    - 最大值定在```mean+2*std```, 最小值訂在```mean-2*std```，再做```(x-min)/(max-min)```所以標準化後，outliers的值會小於0和大於1
- Valid: Special normalization 
    - 最大值定在```mean+2*std```, 最小值訂在```mean-2*std```，再做```(x-min)/(max-min)```所以標準化後，outliers的值會小於0和大於1

- With feature "Date", "Time"
```
(neurons, batchsize, trainloss, validloss)
(50, 100, 59.0961, 85.2851)
```

- Without feature "Date", "Time"
```
epoch (neurons, batchsize, trainloss, validloss)
epoch 5 (50, 100, 57.3424, 17.3289)
epoch 10(50, 100, 42.3814, 13.6609)
epoch 15(50, 100, 32.2412, 11.7947)
epoch 20(50, 100, 25.6744, 11.3446)
epoch 30(50, 100, 15.9398, 12.9544)
epoch 40(50, 100, 10.4048, 14.1605)
epoch 50(50, 100, 7.7914, 13.7575)
epoch 60(50, 100, 15.9398, 12.9544)
```

## Final accuracy
### Using CASE4
```
5  epoch: 78.97802
10 epoch: 80.16597
15 epoch: 82.47934
20 epoch: 83.88224
30 epoch: 85.38624
40 epoch: 85.54819 -> best
50 epoch: 85.52185
60 epoch: 85.15427
```
![](https://i.imgur.com/EwGQARj.png)

