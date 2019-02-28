#include <stdio.h>
#include <stdlib.h>


// read stdin if no argument given.
// cat.cの改造版
// コマンドライン引数でファイルが与えられなかったら、標準入力から読む


static void do_cat(FILE *f);

int main(int argc, char const *argv[]) {
    if (argc == 1) {
        do_cat(stdin);
    } else {
        for (int i = 1; i < argc; i++) {
            FILE *f;

            f = fopen(argv[i], "r");
            if (!f) {
                perror(argv[i]);
                exit(1);
            }
            do_cat(f);
            fclose(f);
        }
    }

    exit(0);
}

static void do_cat(FILE *f) {
    int c;

    while ((c = fgetc(f)) != EOF) {
        if (putchar(c) < 0) exit(1);
    }
}
