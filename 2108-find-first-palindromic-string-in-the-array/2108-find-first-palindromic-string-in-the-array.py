class Solution:
    def firstPalindrome(self, words: List[str]) -> str:
    
        for i in words:
            if(i[::-1]==i):
                return i
            
        return ""