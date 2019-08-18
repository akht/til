IO.pipe do |read_io, write_io|
    # 1つ目のコマンドを実行するプロセス
    fork do
        STDOUT.reopen(write_io) # 標準出力をパイプにつけかえる
        exec 'ps', '-x'
    end

    # 2つ目のコマンドを実行するプロセス
    fork do
        STDIN.reopen(read_io)
        exec 'wc', '-l'
    end
end
Process.waitall