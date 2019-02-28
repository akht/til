#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

static void do_cat(const char *path);
static void die(const char *s);

int main(int argc, char const *argv[]) {
    if (argc < 2) {
        fprintf(stderr, "%s: file name not given\n", argv[0]);
        exit(1);
    }

    for (int i = 1; i < argc; i++) {
        do_cat(argv[i]);
    }

    exit(0);
}

#define BUFFER_SIZE 2048

static void do_cat(const char *path) {
    int fd;
    unsigned char buf[BUFFER_SIZE];
    int n;

    fd = open(path, O_RDONLY);  // ファイルを開く
    if (fd < 0) die(path);      // ちゃんと開けたかチェック

    for (;;) {

        // ファイルディスクリプタfdが示すストリームにbufからバイト列を読み込む
        // 読み込むサイズは最大でもsizeof buf、つまりbuf配列のサイズまで
        // ただし、必ずしもこのサイズ一杯まで読まれる訳ではない
        // 実際に読まれたバイト数はread()の戻り値としてnに保持する
        n = read(fd, buf, sizeof buf);

        // 読み込みが成功したかチェック
        if (n < 0) die(path);

        // 最後まで読んだかチェック
        if (n == 0) break;

        // 実際に読み込んだバイト数を標準出力に書き込む
        // ついでに成功したかどうかチェックして、失敗してればdie()を呼び出す
        if (write(STDOUT_FILENO, buf, n) < 0) die(path);
    }

    if (close(fd) < 0) die(path);   // ファイルを閉じる
}

static void die(const char *s) {
    perror(s);
    exit(1);
}