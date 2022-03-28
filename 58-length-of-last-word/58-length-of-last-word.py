class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        count=0
        blankcount=1
        for i in range(len(s)-1,-1,-1):
            
            if(s[i]==" " and blankcount!=0):
                blankcount+=1
            elif(s[i]!=" "):
                count+=1
                blankcount=0
            else:
                break
            
        
        return count
            
        