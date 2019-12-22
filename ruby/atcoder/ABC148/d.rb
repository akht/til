n = gets.to_i
an = gets.strip.split.map(&:to_i)

count = 0
now = 1
an.each do |a|
  if a == now
    now += 1
  else
    count += 1
  end
end

puts count == n ? -1 : count
