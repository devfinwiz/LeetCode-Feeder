class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        hold=set(nums)
        hold=list(hold)
        
        if(len(nums)==len(hold)):
            return False
        else:
            return True