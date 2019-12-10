def lower_bound(list, target)
  ng = -1
  ok = list.size
  while (ok - ng).abs > 1 do
      mid = (ok + ng) / 2
      if target <= list[mid]
          ok = mid
      else
          ng = mid
      end
  end
  return ok
end

def upper_bound(list, target)
  ng = -1
  ok = list.size
  while (ok - ng).abs > 1 do
    mid = (ok + ng) / 2
    if target < list[mid]
      ok = mid
    else
      ng = mid
    end
  end
  return ok
end


n = gets.to_i
aa = gets.strip.split.map(&:to_i).sort
bb = gets.strip.split.map(&:to_i).sort
cc = gets.strip.split.map(&:to_i).sort

ans = 0
bb.each do |b|
  count_a = upper_bound(aa, b)
  count_c = n - lower_bound(cc, b)
  ans += count_a * count_c
end

puts ans
