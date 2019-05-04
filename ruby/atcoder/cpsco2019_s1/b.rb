s = gets.strip

memo = Hash.new
s.chars do |c|
    if memo.key?(c)
        memo[c] = memo[c] + 1
    else
        memo[c] = 1
    end
end

if memo.values.uniq.size == 1
    puts 'Yes'
else
    puts 'No'
end