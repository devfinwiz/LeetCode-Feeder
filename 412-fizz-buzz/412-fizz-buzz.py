class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        hold=[]
        res=[]
        for i in range(1,n+1):
            hold.append(i)
        
        for i in hold:
            if(i%3==0 and i%5==0):
                res.append("FizzBuzz")
            elif(i%3==0):
                res.append("Fizz")
            elif(i%5==0):
                res.append("Buzz")
            else:
                res.append(str(i))
        
        return res
                