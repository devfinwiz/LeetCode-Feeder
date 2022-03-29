class Solution:
    def maxArea(self, height: List[int]) -> int:
        left=0
        right=len(height)-1
        maxi=0
        
        while(left<right):
            lbar=height[left]
            rbar=height[right]
            
            minbar=min(lbar,rbar)
            bargap=left-right
            area=abs(minbar*bargap)
            
            maxi=max(maxi,area)
            
            if(lbar<rbar):
                left+=1
            else:
                right-=1
        
        return maxi
        
        
            