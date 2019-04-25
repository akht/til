n, a, b = gets.strip.split.map(&:to_i)

def digit_sum n
    sum = 0
    while n > 0 do
        sum += n % 10
        n /= 10
    end
    sum
end

ans = (1..n)
        .map { |i| [i, digit_sum(i)] }
        .select { |d| a <= d[1] && d[1] <= b }
        .reduce(0) { |sum, d| sum + d[0] }

puts ans