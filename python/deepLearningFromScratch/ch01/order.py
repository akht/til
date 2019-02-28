# coding: utf-8
import numpy as np
import matplotlib.pyplot as plt

x = np.arange(1, 10, 0.1)
y1 = np.log(x)
y4 = x
y2 = np.log(x) * x
y3 = np.power(x, 2)
# y4 = np.power(2, x)

plt.plot(y1, label="logn")
plt.plot(y1, label="n")
plt.plot(y2, label="nlogn")
plt.plot(y3, label="n^2")
# plt.plot(y4, label="2^n")
plt.legend()
plt.show()