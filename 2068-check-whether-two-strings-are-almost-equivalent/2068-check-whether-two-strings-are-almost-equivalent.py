from collections import Counter
class Solution:
    def checkAlmostEquivalent(self, word1: str, word2: str) -> bool:
        
        freq1,freq2=dict(Counter(word1)),dict(Counter(word2))
        hold=0
        
        for i,j in freq1.items():
            if(i in freq2.keys()):
                hold=abs(freq2[i]-freq1[i])
                if(hold>3):
                    return False
            else:
                if(j>3):
                    return False
                
        for i,j in freq2.items():
            if(i in freq1.keys()):
                hold=abs(freq2[i]-freq1[i])
                if(hold>3):
                    return False
            else:
                if(j>3):
                    return False
        
        return True
        