puts "自分: PID(#{Process.pid}) PPID(#{Process.ppid})"

pid = fork do
    puts "子ども: PID(#{Process.pid}) PPID(#{Process.ppid})"
end
Process.waitpid(pid)