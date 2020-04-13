# Given nums = [2, 7, 11, 15], target = 9,

# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].

def two_sum(nums, target)
  nums.size.times do |i|
    size.times do |j|
      if i == j
        next
      end

      if nums[i] + nums[j] == target
        return [i, j]
      end
    end
  end
end

nums = [2, 7, 11, 15]
target = 9
p two_sum(nums, target)
p "-------------------------------"



def two_sum2(nums, target)
  memo = {}

  nums.size.times do |i|
    if memo[nums[i]]
      return [memo[nums[i]], i]
    end

    memo[target - nums[i]] = i
  end
end

nums = [2, 7, 11, 15]
target = 18
p two_sum2(nums, target)
p "-------------------------------"

