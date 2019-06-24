n = gets.to_i
hs = gets.strip.split.map(&:to_i)

# 大きいコスト
inf = 10 << 60

# dp[i]は、足場i+1に辿り着くまでに支払うコストの総和の最小値
dp = Array.new(n, inf)

# 足場1に辿り着くまでに支払うコストの総和の最小値は明らかに0
dp[0] = 0

# 足場2に辿り着くまでに支払うコストの総和の最小値は明らかに(hs[1] - hs[0]).abs
dp[1] = (hs[1] - hs[0]).abs

# 足場3〜足場n-1についてDPテーブルを埋める
(2...n).each do |i|
    dp[i] = [dp[i], dp[i - 1] + (hs[i] - hs[i - 1]).abs].min
    dp[i] = [dp[i], dp[i - 2] + (hs[i] - hs[i - 2]).abs].min
end

puts dp[n - 1]
