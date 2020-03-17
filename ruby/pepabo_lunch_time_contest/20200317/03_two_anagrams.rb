s = gets.strip.chars.sort.join
t = gets.strip.chars.sort.reverse.join

puts s < t ? 'Yes' : 'No'
