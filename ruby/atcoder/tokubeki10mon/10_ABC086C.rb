n = gets.to_i
data = n.times.map { gets.strip.split.map(&:to_i) }

def is_reachable(current, next_data)
    tc, xc, yc = current
    tn, xn, yn = next_data
    dist = (xc - xn).abs + (yc - yn).abs
    
    return false if dist > tn - tc

    (dist - (tn - tc)).even?
end

current = [0, 0, 0]
data.each do |d|
    unless is_reachable(current, d)
        puts 'No'
        exit 0
    end
    current = d
end

puts 'Yes'
