class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        nums.sort()
        size=len(nums)+1
        
        if(0 not in nums):
            return 0
        for i in range(0,size-2):
            
            if((nums[i+1]-i)>1):
                return (nums[i+1]-1)
            
        return nums[size-2]+1
            
        