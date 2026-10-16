def two_sum(nums, target):
    seen = set()
    for i in range(len(nums)):
        if target - nums[i] in seen:
            return True
        seen.add(nums[i])
    return False

nums = [1] * 99998 + [3, 5]
target = 8
expected = True

print(two_sum(nums, target) == expected)
