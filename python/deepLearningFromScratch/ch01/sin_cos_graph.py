# coding: utf-8
import numpy as np
import matplotlib.pyplot as plt

# データ生成
x = np.arange(0, 6, 0.1)    # 0から6まで0.1刻みで生成
y1 = np.sin(x)
y2 = np.cos(x)
y3 = np.tan(x)

# グラフの描画
plt.plot(x, y1, label="sin")
plt.plot(x, y2, linestyle="--", label="cos")    # 破線で描画
plt.plot(x, y3, label="tan")
plt.xlabel("x")     # x軸のラベル
plt.ylabel("y")     # x軸のラベル
plt.title('sin & cos')  # タイトル
plt.legend()
plt.show()
