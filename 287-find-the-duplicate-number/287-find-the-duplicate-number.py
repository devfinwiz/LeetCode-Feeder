from collections import Counter
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        
        count=Counter(nums)
        count=dict(count)
        
        for i,j in count.items():
            if(j>1):
                return i