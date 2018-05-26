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
3000 150 0.001 1024
For testcase 2:
[steps] [batch size] [learning rate] [h1 dim]
3000 100 0.002 512
For testcase 3:
[steps] [batch size] [learning rate] [h1 dim]
3000 200 0.0005 256
```

Output
```
----------Test cases----------
[training_steps, batch_size, learning_rate, h1_dim] -> test_acc
['3000', '150', '0.001', '1024'] -> 0.9771 (best model)
['3000', '100', '0.002', '512'] -> 0.9718
['3000', '200', '0.0005', '256'] -> 0.9703
```

