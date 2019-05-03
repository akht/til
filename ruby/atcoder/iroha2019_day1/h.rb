n = gets.strip.to_i

sum = n.to_s.split('').map { |s| s.to_i }.inject(:+)
if sum < 10
    if sum != n
        puts sum
    else
        puts 10 + sum - 1
    end
else
    a = []
    while 9 < sum
        a.push 9
        sum -= 9
    end
    if sum != 0
        a.push sum
    end
    a.sort!
    ans = a.join('').to_i
    if ans != n
        puts ans
    else
        if a[0] == 9
            puts ([1, 8] + a[1, a.length]).join('')
        else
            puts ([a[0] + 1, 8] + a[2, a.length]).join('')
        end
    end
end
