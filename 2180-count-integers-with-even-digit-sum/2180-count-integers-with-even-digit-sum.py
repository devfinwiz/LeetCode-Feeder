class Solution:
    def countEven(self, num: int) -> int:
        sum=0
        count=0
        
        for i in range(2,num+1):
            sum=0
            while(i>0):
                dig=i%10
                sum+=dig
                i//=10
                
            if(sum%2==0):
                    count+=1
    
        return count
            