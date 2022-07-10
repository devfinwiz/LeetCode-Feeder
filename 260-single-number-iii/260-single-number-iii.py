from collections import Counter
class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        count=Counter(nums)
        count=dict(count)
        res=[]
        
        for i,j in count.items():
            if(j==1):
                res.append(i)
        
        return res