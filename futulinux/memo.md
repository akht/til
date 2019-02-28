# めも

Dockerプロセス確認
```bash
$ docker ps -a
```

Dockerイメージをビルド
```bash
$ docker build -t futulinux .
```

Dockerコンテナを立ち上げる(イメージID)
```bash
Mac
$ docker run -it -v /Users/akht/til/til/futulinux:/workspace 5eacfef9d9be

Windows
$ docker run -it -v C:\usr\til\til\futulinux:/workspace b98924ab9e83
```

コンテナから抜ける(dettach)
`control` + `P` + `Q`

コンテナに入る(attach)
```bash
$ docker attach [コンテナID/NAME]
```

コンテナ停止
```bash
コンテナ内で
$ exit
```

コンテナの起動
```bash
$ docker start [コンテナID/NAME]
```

コンテナの停止
```bash
$ docker stop [コンテナID/NAME]
```