# 深さ優先探索
# https://atc001.contest.atcoder.jp/tasks/dfs_a

h, w = gets.strip.split.map(&:to_i)
grid = h.times.map { gets.strip.split('') }

start_y = 0
start_x = 0
goal_y = 0
goal_x = 0
grid.each_with_index do |line, i|
  line.each_with_index do |b, j|
    if b == 's'
      start_y = i
      start_x = j
    end
    if b == 'g'
      goal_y = i
      goal_x = j
    end
  end
end

# マスの訪問管理
visited = Array.new(h) { Array.new(w, false)}

def dfs(y, x, h, w, grid, visited)
  return if y < 0 || x < 0 || y >= h || x >= w
  return if grid[y][x] == "#"
  return if visited[y][x]

  visited[y][x] = true

  dfs(y + 1, x, h, w, grid, visited)
  dfs(y - 1, x, h, w, grid, visited)
  dfs(y, x + 1, h, w, grid, visited)
  dfs(y, x - 1, h, w, grid, visited)
end

dfs(0, 0, h, w, grid, visited)

puts visited[goal_y][goal_x] ? "Yes" : "No"
