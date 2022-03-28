class Solution:
    def isHappy(self, n: int) -> bool:
        
        if(n>0):
            hold=set()
            
            while(True):
                summ=0
                if(n==1):
                    return True
                    
                while(n>0):
                    dig=n%10
                    summ=summ + dig*dig
                    n=n//10
                n=summ
                if(n in hold):
                    return False
                hold.add(n)
        
        else:
            return False
                
            
            
            
            