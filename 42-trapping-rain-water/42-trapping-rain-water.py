class Solution:
    def trap(self, height: List[int]) -> int:
        if(len(height)<3):
            return 0
        
        volume=0
        left=0                  #5
        right=len(height)-1     #5
        
        lmax=height[left]   #4
        rmax=height[right]  #5
        
        while(left<right):
            lmax,rmax=max(height[left],lmax),max(height[right],rmax)
            #4   #5
            if(lmax<=rmax):
                volume+=(lmax-height[left])*1
                left+=1
            else:
                volume+=(rmax-height[right])*1
                right-=1
        
        return volume