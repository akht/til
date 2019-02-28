# coding: utf-8
import numpy as np


# ANDゲート
def AND(x1, x2):
    x = np.array([x1, x2])      # 入力
    w = np.array([0.5, 0.5])    # 重み
    b = -0.7                    # バイアス
    tmp = np.sum(x * w) + b
    if tmp <= 0:
        return 0
    else:
        return 1


if __name__ == '__main__':
    for xs in [(0, 0), (1, 0), (0, 1), (1, 1)]:
        y = AND(xs[0], xs[1])
        print(str(xs) + " -> " + str(y))