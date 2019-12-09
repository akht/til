fruits = ['apple', 'orange', 'melon']
fruits.each.with_index(10) {|fruit, i| puts "#{i}: #{fruit}"}

dimensions = [
    [10, 20],
    [30, 40],
    [50, 60],
]

areas = []
dimensions.each do |length, width|
  areas << length * width
end
p areas

dimensions.each_with_index do |(length, width), i|
  puts "length:#{length}, width:#{width}, i:#{i}"
end
