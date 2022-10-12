class Solution:
    def integerReplacement(self, n: int) -> int:
        count=0
        while(n>1):
            if(n==3):
                return count+2
            if(n%2==0):
                n//=2
            elif((n+1)%4==0):
                n+=1
            else:
                n-=1
            count+=1
        
        return count
        
        
        