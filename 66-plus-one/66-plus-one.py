class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        appender=""
        res=[]
        
        for i in digits:
            appender+=str(i)
            
        hold=int(appender)+1
        hold2=str(hold)
        
        for i in hold2:
            appender2=int(i)
            res.append(appender2)
            
        return res
            
            
            
        