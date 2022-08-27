class Solution:
    def trap(self, height: List[int]) -> int:
        if(len(height)<3):
            return 0
        
        volume=0
        left=0
        right=len(height)-1
        
        lmax=height[left]
        rmax=height[right]
        
        while(left<right):
            lmax=max(height[left],lmax)
            rmax=max(height[right],rmax)
            
            if(lmax<=rmax):
                volume+=(lmax-height[left])*1
                left+=1
            else:
                volume+=(rmax-height[right])*1
                right-=1
        
        return volume