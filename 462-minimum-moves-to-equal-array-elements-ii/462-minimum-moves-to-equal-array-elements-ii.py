class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        count=0
        nums.sort() # sort the given nums
        mid=nums[len(nums)//2] # our mid element
        for num in nums:
            count+=abs(mid-num)
        return count