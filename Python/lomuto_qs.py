def part(l, r, nums):
    pt=nums[r]
    i=l-1
    for j in range(l, r):
        if nums[j]<pt:
            i+=1
            nums[i], nums[j]= nums[j], nums[i]
    nums[i+1], nums[r]= nums[r], nums[i+1]
    return i+1
def quicks(l, r, nums):
    if l<r:
        p=part(l, r, nums)
        quicks(l, p-1, nums)
        quicks(p+1, r, nums)
if len(nums)<2:
    return
quicks(0, len(nums)-1, nums)
