s = gets.strip

# 10^100はめちゃくちゃ多い回数なので最終的にRLに集まりそう

ans = Array.new(s.length, 0)

s.length.times do |i|
    cur_char = s[i]
    next_char = s[i + 1]
    
    if next_char.nil?
        break
    end

    if cur_char + next_char == "RL"
        j = i
        while j >= 0 && s[j] == 'R' do
            ans[i + (i - j) % 2] += 1
            j -= 1
        end

        k = i + 1
        while k < s.length && s[k] == 'L' do
            ans[i + (k - i) % 2] += 1
            k += 1
        end
    end
end

puts ans.join(" ")