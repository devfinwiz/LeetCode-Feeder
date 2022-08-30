class Solution:
    def numDecodings(self, s: str) -> int:
        answer=1
        prev=1
        
        one,two=False,False
        
        for i in s:
            if(i=='*'):
                new=answer*9
                if(one):
                    new+=9*prev
                if(two):
                    new+=6*prev
                one,two=True,True
            else:
                new=answer if(i>'0') else 0
                if(one):
                    new+=prev
                if(two and i<='6'):
                    new+=prev
                one=(i=='1')
                two=(i=='2')
                
            prev=answer
            answer=new%(10**9+7)
        return answer