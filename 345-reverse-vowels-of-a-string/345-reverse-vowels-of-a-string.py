class Solution:
    def reverseVowels(self, s: str) -> str:
        vowels=['a','e','i','o','u','A','E','I','O','U']
        hold=[]
        count=0
        
        for i in range(len(s)):
            if(s[i] in vowels):
                hold.append(s[i])
                s=s.replace(s[i],'_',1)
        hold=hold[::-1]
    
        for i in range(len(s)):
            if(s[i]=='_'):
                s=s.replace(s[i],hold[count],1)
                count+=1
        return s
                