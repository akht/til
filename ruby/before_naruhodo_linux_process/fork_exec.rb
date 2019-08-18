puts "自分: PID(#{Process.pid}) PPID(#{Process.ppid})"

pid = fork do
    exec 'ps', '-l'
    puts '子どもは別の道に進んだのでもうこの道は通らない'
end
Process.waitpid(pid)
puts "psコマンドが実行されたはず"