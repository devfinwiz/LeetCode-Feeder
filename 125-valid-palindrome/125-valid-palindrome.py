class Solution:
    def isPalindrome(self, s: str) -> bool:
        
        lower=s.lower()
        
        lowerrev="".join(filter(str.isalnum,lower))
        
        reverse="".join(reversed(lowerrev))
        
        if(reverse==lowerrev):
            return True
        
        return False