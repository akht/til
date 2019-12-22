require 'minitest/autorun'

# 探索したい値以上が現れる最初の位置を返す
def lower_bound(arr, n)
  ng = -1
  ok = arr.size
  while (ok - ng).abs > 1
    mid = (ok + ng) / 2
    if n <= arr[mid]
      ok = mid
    else
      ng = mid
    end
  end
  ok
end

# 探索したい値より大きい値が現れる最初の位置を返す
def upper_bound(arr, n)
  ng = -1
  ok = arr.size
  while (ok - ng).abs > 1
    mid = (ok + ng) / 2
    if n < arr[mid]
      ok = mid
    else
      ng = mid
    end
  end
  ok
end

class BinarySearchTest < Minitest::Test
  def test_lower_bound
    a = [1, 1, 2, 2, 3, 3, 4, 5]
    assert_equal 0, lower_bound(a, -1)
    assert_equal 0, lower_bound(a, 0)
    assert_equal 0, lower_bound(a, 1)
    assert_equal 2, lower_bound(a, 2)
    assert_equal 4, lower_bound(a, 3)
    assert_equal 7, lower_bound(a, 5)
    assert_equal 8, lower_bound(a, 100)
  end

  def test_upper_bound
    a = [1, 1, 2, 2, 3, 3, 4, 5]
    assert_equal 0, upper_bound(a, -1)
    assert_equal 0, upper_bound(a, 0)
    assert_equal 2, upper_bound(a, 1)
    assert_equal 4, upper_bound(a, 2)
    assert_equal 6, upper_bound(a, 3)
    assert_equal 8, upper_bound(a, 5)
    assert_equal 8, upper_bound(a, 100)
  end
end
