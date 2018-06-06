# Parallel MNIST
## MNIST_multiGPU
### Usage
```
$ USAGE: ./MNIST_multiGPU.py [# of model] [# of GPU]
$ For testcase
$ [steps] [batch size] [learning rate] [h1 dim]
```
The program trains each model in parallel

### Example
Execute
```
$ ./MNIST_multiGPU.py 3 3
For testcase 1:
[steps] [batch size] [learning rate] [h1 dim]
3000 150 0.001 1000
For testcase 2:
[steps] [batch size] [learning rate] [h1 dim]
3000 500 0.003 256
For testcase 3:
[steps] [batch size] [learning rate] [h1 dim]
3000 500 0.003 1000
```

Output
```
----------Test cases----------
[training_steps, batch_size, learning_rate, h1_dim] -> test_acc
['3000', '150', '0.001', '1000'] -> 0.9723
['3000', '500', '0.003', '256'] -> 0.9784
['3000', '500', '0.003', '1000'] -> 0.9813 (best model)
```

