class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if(len(nums)==1):
            return nums
        for i in nums:
            if(i==0):
                hold=nums.pop(nums.index(i))
                nums.append(hold)
        
        
        
        