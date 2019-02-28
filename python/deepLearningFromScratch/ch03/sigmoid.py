# coding: utf-8
import numpy as np
import matplotlib.pyplot as plt


# シグモイド関数
def sigmoid(x):
    return 1 / (1 + np.exp(-x))


x = np.arange(-5.0, 5.0, 0.1)
y = sigmoid(x)
plt.plot(x, y)
plt.ylim(-0.1, 1.1)     # y軸の範囲を指定
plt.show()
