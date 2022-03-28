class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        size=len(s)
        
        for i in range(size-1,-1,-1):
            s.append(s[i])
        
        for i in range(0,size):
            s.remove(s[i])
            
            
            
            