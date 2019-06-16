n, k = gets.strip.split.map(&:to_i)
as = gets.strip.split.map(&:to_i)

ans = 0
sum = 0
right = 0
n.times do |left|
    while right < n && sum < k
        sum += as[right]
        right += 1
    end

    # rightを限界まで動かしてもsumがkより小さければ
    # leftを動かしても無駄なので終了
    break if sum < k

    ans += n - right + 1

    if right == left
        right += 1
    else
        # leftが次の値になる前の準備
        sum -= as[left]
    end
end

puts ans
