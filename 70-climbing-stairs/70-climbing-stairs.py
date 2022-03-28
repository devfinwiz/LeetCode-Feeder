class Solution(object):
    def climbStairs(self, N):
        """
        :type n: int
        :rtype: int
        """
        
        steps=[None]*(N+1)
        
        steps[0]=1
        steps[1]=1
        
        for i in range(2,N+1):
            steps[i]=steps[i-1]+steps[i-2]
            
        return steps[N]
        
        
        