r, d, x = gets.strip.split.map(&:to_i)

10.times {
    x = r * x - d
    puts x
}
