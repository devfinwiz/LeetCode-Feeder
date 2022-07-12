class Solution:
    def longestPalindrome(self, s: str) -> str:
        maxlenstr=""
        
        for i in range(len(s)-1):
            for j in range(i+1,len(s)):
                if(s[i]==s[j]):
                    hold=s[i:j+1]
                    if(len(hold)>len(maxlenstr)):
                        if(hold==hold[::-1]):
                            maxlenstr=hold
        
        if(len(maxlenstr)==0):
            return s[0]
        
        return maxlenstr