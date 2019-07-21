n, d = gets.strip.split.map(&:to_i)

# ひとりで2 * d + 1本みれるので、切り上げればおk

puts (n.to_f / (2 * d + 1)).ceil