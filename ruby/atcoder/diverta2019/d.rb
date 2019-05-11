require 'prime'

n = gets.to_i

class Integer
    def divisor_list
        return [] if self <= 0
        return [1] if self == 1
  
        prime_division.map.with_index { |(base, k), i|
            s = i.zero? ? 0 : 1
            (s..k).map { |n| base ** n }
        }.inject { |res, e| res + res.flat_map { |t| e.map { |v| t * v } } }.sort
    end
end
  
ans = 0
list = n.divisor_list
list.each do |i|
    m = i - 1
    if m != 0
        if n / m == n % m
            ans += m
        end
    end
end

puts ans