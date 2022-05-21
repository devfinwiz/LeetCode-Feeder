from collections import Counter
class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        hold=Counter(nums)
        hold=dict(hold)
        
        for i,j in hold.items():
            if(j%2==0):
                pass
            else:
                return False
        
        return True