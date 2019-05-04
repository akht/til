n, k = gets.strip.split.map(&:to_i)
as = gets.strip.split.map(&:to_i)

# 一桁ずつ処理していく
# 563だったら、最初3は3回(1と1と1)、次の6は2回(5と1)、次の5は1回(5)

ans = 10 ** 18
as.combination(k) do |arr|
    sum = arr.inject(:+)
    result = 0
    while sum > 0
        d = sum % 10
        result += (d >= 5 ? d - 4 : d)
        sum /= 10
    end
    ans = result if ans > result
end

puts ans