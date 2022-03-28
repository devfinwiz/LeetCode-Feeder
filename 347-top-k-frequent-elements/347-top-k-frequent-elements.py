from collections import Counter
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count=Counter(nums)
        count=dict(count)
        
        res=[]
        for i in range(k):
            maxval=max(count,key=count.get)
            res.append(maxval)
            count.pop(maxval)
            
        return res
    
            
            