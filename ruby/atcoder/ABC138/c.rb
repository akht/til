n = gets.to_i
vs = gets.strip.split.map(&:to_i).sort

tmp = 0
n.times do |i|
    cur = vs[i]
    nex = vs[i + 1]
    break if nex.nil?
    tmp = (cur + nex) / 2.0
    vs[i + 1] = tmp
end

puts vs[n - 1]