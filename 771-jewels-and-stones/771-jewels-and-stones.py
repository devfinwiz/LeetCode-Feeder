class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        
        count=0
        j=[]
        s=[]
        
        for i in jewels:
            j.append(i)
        for i in stones:
            s.append(i)
        
        for i in s:
            if(i in j):
                count+=1
                
        return count
            