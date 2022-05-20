import numpy as np
class Solution:
    def maxConsecutive(self, bottom: int, top: int, special: List[int]) -> int:
        special.sort()
        
        first=special[0]-bottom
        last=top-special[-1]
        maxx=0
        
        for i in range(1,len(special)):
            hold=(special[i]-special[i-1])-1
            maxx=max(hold,maxx)
            
        return max(first,last,maxx)
        
            