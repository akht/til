# receipts = [230, 330, 450, 500, 510, 520, 530, 600, 700, 1000, 1650, 1890]
receipts = [1380, 1380, 530, 1296, 703]

limit = 5000
max = 0
max_bits = []

[0, 1].repeated_permutation(receipts.size) do |bits|
    kane = bits.map.with_index{|v, i| v * receipts[i]}.sum
    next if kane > 5000
    if kane > max
        max = kane
        max_bits = bits
    end
end

c = max_bits.map.with_index {|v, i| v * receipts[i]}
puts "#{max}円 #{c}"


# 経費精算、領収書の山からいくつか選んで5000円に一番近い組み合わせを出してくれるすごいやつがほしい...