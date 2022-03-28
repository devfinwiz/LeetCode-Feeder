class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        hold=[]
        
        if(target in nums):
            return (nums.index(target))
        
        if(target>nums[-1]):
            hold3=nums.index(nums[-1])
            hold3=hold3+1
            return hold3
    
            
        hold=nums
        hold.append(target)
        hold.sort()
        
        return (hold.index(target))
                
                
                            
                            
        