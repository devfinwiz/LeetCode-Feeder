from collections import Counter
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        
        dic=dict(Counter(nums))
        
        for i,j in dic.items():
            if(j==1):
                return i
            
        
            
            
                    
                    
                    
                    
                    
            