n = gets.to_i
an = gets.strip.split.map(&:to_i).sort.reverse

memo = {}
two = []
four = []
an.each do |a|
  if memo[a].nil?
    memo[a] = 1
  else
    memo[a] += 1
  end
  if memo[a] == 2
    two << a
  end
  if memo[a] == 4
    four << a
  end
end

if four.size > 0
  if two.size >= 2
    puts [four[0] * four[0], two[0] * two[1]].max
  else
    puts four[0] * four[0]
  end
else
  if two.size >= 2
    puts two[0] * two[1]
  else
    puts 0
  end
end
