class Solution:
    def numDecodings(self, s: str) -> int:
        answer=1
        prev=1
        one,two=False,False
        
        for i in s:
            new=answer if(i>'0') else 0
            if(one):
                new+=prev
            if(two and i<='6'):
                new+=prev
            one=(i=='1')
            two=(i=='2')
            
            prev=answer
            answer=new
            
        return answer