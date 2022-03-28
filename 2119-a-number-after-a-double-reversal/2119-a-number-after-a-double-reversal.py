class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        reversed1=0
        reversed2=0
        copy=num
        
        while(num>0):
            dig=num%10
            reversed1=(reversed1*10)+dig
            num//=10
            
        while(reversed1>0):
            dig1=reversed1%10
            reversed2=(reversed2*10)+dig1
            reversed1//=10
        
        if(reversed2==copy):
            return True
        
        return False