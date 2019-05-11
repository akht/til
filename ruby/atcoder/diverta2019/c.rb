n = gets.strip.to_i
ss = n.times.map { gets.strip }

count = 0
xa = 0
ba = 0
bx = 0

ss.each do |s|
    (0..s.length-2).each do |i|
        if s[i] + s[i+1] == "AB"
            count += 1
        end
    end

    if s.start_with?("B") && s.end_with?("A")
        ba += 1
        next
    end
    if s.end_with?("A")
        xa += 1
        next
    end
    if s.start_with?("B")
        bx += 1
        next
    end
end

s2 = ""
while xa > 0 || ba > 0 || bx > 0
    if s2 == ""
        if xa > 0
            s2 += "XA"
            xa -= 1
        elsif ba > 0
            s2 += "BA"
            ba -= 1
        elsif bx > 0
            s2 += "BX"
            bx -= 1
        end
    else
        if s2.end_with?("A")
            if ba > 0
                s2 += "BA"
                ba -= 1
            elsif bx > 0
                s2 += "BX"
                bx -= 1
            elsif xa > 0
                s2 += "XA"
                xa -= 1
            end
        else
            if ba > 0
                s2 += "BA"
                ba -= 1
            elsif xa > 0
                s2 += "XA"
                xa -= 1
            elsif bx > 0
                s2 += "BX"
                bx -= 1
            end
        end
        
    end
end

count2 = 0
(0..s2.length-2).each do |i|
    if s2[i] + s2[i+1] == "AB"
        count2 += 1
    end
end

puts count + count2
