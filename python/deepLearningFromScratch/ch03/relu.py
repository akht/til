# coding: utf-8
import numpy as np
import matplotlib.pyplot as plt


# ReLU(Rectified Linear Unit)関数
def relu(x):
    return np.maximum(0, x)


x = np.arange(-5.0, 5.0, 0.1)
y = relu(x)
plt.plot(x, y)
plt.ylim(-1, 5.5)     # y軸の範囲を指定
plt.show()
