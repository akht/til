n = gets.to_i
ss = []
n.times { ss << gets.strip }
m = gets.to_i
tt = []
m.times { tt << gets.strip }

ans = 0
ss.each do |w|
  blue = ss.select {|s| s == w}.count
  red = tt.select {|s| s == w}.count
  next if blue - red <= 0
  ans = [ans, blue - red].max
end

puts ans
