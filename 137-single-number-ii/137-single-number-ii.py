from collections import Counter
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        count=Counter(nums)
        count=dict(count)
        res=[]
        
        for i,j in count.items():
            if(j!=3):
                return i
        
        