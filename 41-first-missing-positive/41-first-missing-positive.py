class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        nums = set(nums)
        for i in range(1,len(nums)+1):
            if i not in nums:
                return i
        return i+1