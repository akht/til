n = gets.to_i

puts (1.upto n).map{|i| Math.log10(i).floor + 1 }.count{|i| i.odd? }