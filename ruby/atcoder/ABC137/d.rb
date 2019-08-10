n, m = gets.strip.split.map(&:to_i)
abs = n.times.map { gets.strip.split.map(&:to_i) }

abs.sort! {|a, b| (b[1] <=> a[1]).nonzero? || b[0] <=> a[0]}
days = (1..m).to_a

ans = 0
abs.each do |day, reward|
    index = days.bsearch_index { |d| d >= day }
    if index
        days.delete_at(index)
        ans += reward
    end
end

puts ans