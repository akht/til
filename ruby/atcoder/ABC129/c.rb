n, m = gets.strip.split.map(&:to_i)
as = m.times.map { gets.strip.to_i }

mod = 1_000_000_007

broken = Array.new(n, false)
as.each do |a|
    broken[a] = true
end

dp = Array.new(n + 1, 0)
dp[0] = 1

n.times do |i|
    if !broken[i + 1]
        dp[i + 1] += dp[i]
        dp[i + 1] %= mod
    end

    if i + 2 <= n && !broken[i + 2]
        dp[i + 2] += dp[i]
        dp[i + 2] %= mod
    end
end

puts dp[n]
