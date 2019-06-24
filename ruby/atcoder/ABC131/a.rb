s = gets.strip

now = ''
ans = 'Good'
s.split('').each do |i|
    if now == i
        ans = 'Bad'
    end
    now = i
end

puts ans