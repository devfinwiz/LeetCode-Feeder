class Solution:
    def reverse(self, x: int) -> int:
        reversed=0
        copy=x
        if(copy<0):
            x=abs(x)
            
        while(x>0):
            dig=x%10
            reversed=reversed*10+dig
            x//=10
        
        if(copy<0):
            reversed=str(reversed)
            reversed="-"+reversed
            reversed=int(reversed)
            
        if(-2147483648<=reversed<=2147483647):
            return reversed
        
        return 0