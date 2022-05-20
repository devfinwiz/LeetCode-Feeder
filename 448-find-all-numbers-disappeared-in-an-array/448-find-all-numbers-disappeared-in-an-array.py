class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res=[]
        
        hold=[n for n in range(1,len(nums)+1)]
        nums=set(nums)
        
        for i in hold:
            if(i not in nums):
                res.append(i)
        
        return res
                