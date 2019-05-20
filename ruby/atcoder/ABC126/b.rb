s = gets.strip.to_i

x = s / 100
y = s % 100

if 1 <= x && x <= 12
    if 1 <= y && y <= 12
        puts "AMBIGUOUS"
    else
        puts "MMYY"
    end
else
    if 1 <= y && y <= 12
        puts "YYMM"
    else
        puts "NA"
    end
end