class Solution:
    def addDigits(self, num: int) -> int:
        
        temp=num
        sum=0
        hold=[1,2,3,4,5,6,7,8,9,0]
        if(num in hold):
            return num
        
        def countdig(n):
            count=0
            while(n>0):
                n//=10
                count+=1
            return count
            
        while(temp>0):
            dig=temp%10
            sum+=dig
            temp//=10
            
            if(temp==0 and countdig(sum)==1):
                return sum
            elif(temp==0 and countdig(sum)>1):
                temp=sum
                sum=0
                
                
            
                
            
            
                
            
            