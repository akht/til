puts "標準入力のファイルディスクリプタ: #{STDIN.fileno}"
puts "標準出力のファイルディスクリプタ: #{STDOUT.fileno}"

file = File.open('a.txt', 'w')
puts "a.txtへの入出力のファイルディスクリプタ: #{file.fileno}"

# 標準出力をa.txtへの出力に付け替える
STDOUT.reopen(file)
puts '標準出力先が変わってるはず'