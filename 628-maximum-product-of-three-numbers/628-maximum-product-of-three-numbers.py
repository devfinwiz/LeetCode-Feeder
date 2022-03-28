class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        
        nums.sort(reverse=True)
        
        max1=nums[0]
        max2=nums[1]
        max3=nums[2]
        min1=nums[-1]
        min2=nums[-2]
        
        res=max(max1*max2*max3,min1*min2*max1)
        
        return res