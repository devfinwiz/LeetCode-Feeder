class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(target not in nums):
            return [-1,-1]
        res=[]
        
        count=nums.count(target)-1
        res.append(nums.index(target))
        res.append(nums.index(target)+count)
        
        return res
        
            