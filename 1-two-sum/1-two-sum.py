class Solution(object):
    def twoSum(self, nums, target):
        for i in nums:
            temp = list(nums)
            temp.remove(i)
            for j in temp:
                if i+j == target:
                    return [nums.index(i),nums.index(j,nums.index(i)+1)]