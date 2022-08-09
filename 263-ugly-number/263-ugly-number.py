
class Solution:
    def isUgly(self, n: int) -> bool:
        
        if(n==0):
            return False
        hold=[2,3,5]
        for i in hold:
            while(n%i==0):
                n=n//i
        return n==1