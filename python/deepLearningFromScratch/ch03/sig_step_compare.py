# coding: utf-8
import numpy as np
import matplotlib.pyplot as plt


# ステップ関数
def step_function(x):
    y = x > 0
    return y.astype(np.int)


# シグモイド関数
def sigmoid(x):
    return 1 / (1 + np.exp(-x))


x = np.arange(-5.0, 5.0, 0.1)
y1 = step_function(x)
y2 = sigmoid(x)
plt.plot(x, y1)
plt.plot(x, y2, 'k--')
plt.ylim(-0.1, 1.1)     # y軸の範囲を指定
plt.show()
