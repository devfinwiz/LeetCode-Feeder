class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        orig=0
        reversednum=0
        if(x<0):
                return False
        
        orig=x
        
        while(x!=0):
            
            digit=x%10
            reversednum=reversednum*10+digit
            x=x//10
    
        if(reversednum==orig):
            return True
        else:
            return False
        