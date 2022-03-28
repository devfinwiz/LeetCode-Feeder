class Solution:
    def arrangeCoins(self, n: int) -> int:
        pos_rows=n//2+1
        itercount=0
        res=0
        
        if(n==1):
            return 1
        
        while(n>0):
            for i in range(pos_rows+1):
                itercount+=1
                n-=itercount
                if(n>=0):
                    res+=1
                else:
                    break
        return res
                
            
            
            
            