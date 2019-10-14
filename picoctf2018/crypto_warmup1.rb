alphabet = [*'a'..'z']
message = "llkjmlmpadkkc"
key = "thisisalilkey"
flag = message.each_char.zip(key.each_char).map {|t| alphabet[(t.first.ord - t.last.ord) % 26]}.join
puts "picoCTF{#{flag.upcase}}"
