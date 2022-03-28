class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        nums=set(nums)
        nums=list(nums)
        
        if(len(nums)==1):
            return nums[0]
        if(len(nums)==2):
            return max(nums[0],nums[1])
        
        maxi1=max(nums)
        nums.remove(maxi1)
        maxi2=max(nums)
        nums.remove(maxi2)
        maxi3=max(nums)
        
        return maxi3
            
            