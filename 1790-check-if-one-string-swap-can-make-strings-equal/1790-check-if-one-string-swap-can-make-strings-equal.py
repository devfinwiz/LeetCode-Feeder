class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        count=0
        hold1=[]
        hold2=[]
        
        for i in s1:
            hold1.append(i)
        for i in s2:
            hold2.append(i)
        for i in s1:
            if(i not in s2):
                return False
            if(s1.count(i)!=s2.count(i)):
                return False
        if(s1==s2):
            return True
        if(len(s1)!=len(s2)):
            return False
        for i in range(len(s1)):
            if(s1[i]!=s2[i]):
                count+=1
            if(count==3):
                return False
        
        return True