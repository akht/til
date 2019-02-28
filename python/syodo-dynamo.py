#coding: utf-8

# spi, time ライブラリをインポート
import spidev
import time
# コマンド実行ライブラリ
import subprocess
# センサーデータのJSON化のためにインポート
import json
from datetime import datetime

# SpiDev オブジェクトのインスタンスを生成
spi = spidev.SpiDev()
# ポート0、デバイス0のSPI をオープン
spi.open(0, 0)
# 最大クロックスピードを1MHz に設定
spi.max_speed_hz=1000000
# 1 ワードあたり8ビットに設定
spi.bits_per_word=8

# ダミーデータを設定（1111 1111）
dummy = 0xff
# スタートビットを設定（0100 0111）
start = 0x47
# シングルエンドモードを設定 （0010 0000）
sgl = 0x20
# ch0 を選択（0000 0000）
ch0 = 0x00
# ch1 を選択（0001 0000）
ch1 = 0x10
# MSB ファーストモードを選択（0000 1000）
msbf = 0x08
# IC からデータを取得する関数を定義
def measure(ch):
    # SPI インターフェイスでデータの送受信を行う
    ad = spi.xfer2( [ (start + sgl + ch + msbf), dummy ] )
    #
    val = ((ad[0] & 0x03) << 8) + ad[1]
    # 受信した2バイトのデータを10 ビットデータにまとめる
    voltage =  ( val * 3.3 ) / 1023
    # 結果を返す
    return val, voltage
try:
    # 無限ループ
    while 1:
        # 関数を呼び出してch1 のデータを取得
        ch1_val, ch1_voltage  = measure(ch1)
        # 結果を表示
        #print  'ch1 = {:4d}, {:2.2f}[V]'.format(ch1_val, ch1_voltage)
        # センサーデータをJSON化するため辞書に入れる。後々のデータ処理に用いる
        # JSONデータ構造 {"brightness": ch1_val, "ID": "id001", "time_sensor": "2015-10-15 16:21:56"}
        # "ID": "id001"の001の部分はデバイスによって変える
        json_data = {"time_sensor": datetime.now().strftime('%Y-%m-%d %H:%M:%S'), "ID": "id001", "brightness": ch1_val}
        encode_json_data = json.dumps(json_data)
        #json_dataを標準出力し、ログファイルに追記
        print encode_json_data
        f = open("/home/pi/shodo-logs/shodo-dynamo.log","a")
        f.write(encode_json_data)
        f.write("\n")
        f.close()
        # 3秒待つ
        time.sleep(3)

# キーボード例外を検出
except KeyboardInterrupt:
    # 何も処理をしない
    pass

# SPI を開放
spi.close()