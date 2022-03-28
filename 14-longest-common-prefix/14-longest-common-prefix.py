class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        lcp = ""
        
        if strs is None or len(strs) == 0:
            return lcp
        
        minimumLength = len(strs[0])
        for i in range(1, len(strs)):
            minimumLength = min(minimumLength, len(strs[i]))
        
        for i in range(0, minimumLength):
            
            current = strs[0][i]
            
            for j in range(0, len(strs)):
                if strs[j][i] != current:
                    return lcp
            lcp += current
        return lcp
                
                
                
        