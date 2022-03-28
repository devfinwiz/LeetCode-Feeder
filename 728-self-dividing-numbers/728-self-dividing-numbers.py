class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        
    
        hold=[]
        for i in range(left,right+1):
            copy=i
            while(i>0):
                dig=i%10
                i//=10
                if(dig==0):
                    break
                if(copy%dig==0 and i==0):
                    hold.append(copy)
                elif(copy%dig!=0):
                    break
        return hold
        
            
                