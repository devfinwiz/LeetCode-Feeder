import numpy as np
class Solution:
    def maxConsecutive(self, bottom: int, top: int, special: List[int]) -> int:
        special.sort()
        maxx=0
        
        for i in range(1,len(special)):
            hold=(special[i]-special[i-1])-1
            maxx=max(hold,maxx)
            
        return max(special[0]-bottom,top-special[-1],maxx)
        
            