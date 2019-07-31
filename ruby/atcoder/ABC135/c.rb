n = gets.to_i
as = gets.strip.split.map(&:to_i)
bs = gets.strip.split.map(&:to_i)

# こういうのは後ろからやるのがよさそう

monsters = 0

(n - 1).downto(0) do |i|
    b = bs[i]
    a_1 = as[i + 1]
    a_0 = as[i]

    if a_1 < b
        b -= a_1
        monsters += a_1
        as[i + 1] = 0
    else
        as[i + 1] -= b
        monsters += b
        b = 0
    end

    if b > 0
        if a_0 < b
            b -= a_0
            monsters += a_0
            as[i] = 0
        else
            as[i] -= b
            monsters += b
            b = 0
        end
    end
end

puts monsters