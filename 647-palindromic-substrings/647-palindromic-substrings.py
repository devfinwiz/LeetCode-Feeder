class Solution:
    def countSubstrings(self, s: str) -> int:
        count=0
        
        maxstr=""
        hold=""
        for i in range(len(s)-1):
            for j in range(i+1,len(s)):
                if(s[i]==s[j]):
                    hold=s[i:j+1]
                    if(hold==hold[::-1]):
                        count+=1
        
        
        return count+len(s)