class Solution:
    def maxArea(self, height: List[int]) -> int:
        left=0
        right=len(height)-1
        maximum=0
        
        while(left<right):
            lbar=height[left]
            rbar=height[right]
            
            maximum=max(maximum,(min(lbar,rbar)*(right-left)))
            
            if(lbar<rbar):
                left+=1
            else:
                right-=1
        
        return maximum
        
        
            