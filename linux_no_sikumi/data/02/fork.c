#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <err.h>

// fork()関数によってプロセスが生成される様子をみるためのやつ

// 1. プロセスを新規生成する
// 2. 親プロセスは、自身のプロセスIDと子プロセスのプロセスIDを出力して終了する。子プロセスは自身のプロセスIDを出力して終了する。

static void child()
{
    printf("I'm child! my pid is %d.\n", getpid());
    exit(EXIT_SUCCESS);
}

static void parent(pid_t pid_c)
{
    printf("I'm parent! my pid is %d and the pid of my child is %d\n",
            getpid(), pid_c);
    exit(EXIT_SUCCESS);
}

int main(void)
{
    pid_t ret;
    ret = fork();
    if (ret == -1) {
        err(EXIT_FAILURE, "fork() failed");
    }

    if (ret == 0) {
        // child process came here because fork() returns 0 for child process
        child();
    } else {
        // parent process came here because fork() returns the pid of newly created child process (> 1)
        parent(ret);
    }

    // shouldn't reach here
    err(EXIT_FAILURE, "shouldn't reach here");
}