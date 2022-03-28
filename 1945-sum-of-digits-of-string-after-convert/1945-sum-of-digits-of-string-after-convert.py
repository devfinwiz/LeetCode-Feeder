class Solution:
    def getLucky(self, s: str, k: int) -> int:
        
        hold=list(map(chr,range(97,123)))
        strhold=""
        
        for i in s:
            strhold+=str(hold.index(i)+1)
        
        converted=int(strhold)
        
        for i in range(k):
            sum=0
            while(converted>0):
                dig=converted%10
                sum+=dig
                converted//=10
            converted=sum
        return sum
            
                
                
                
        
            
        