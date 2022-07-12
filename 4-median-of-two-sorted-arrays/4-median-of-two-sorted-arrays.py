#import numpy as np
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        #return np.median(nums1+nums2)
        merged=nums1+nums2
        merged.sort()
        
        if(len(merged)%2==0):
            hold=len(merged)//2
            median=(merged[hold-1]+merged[hold])/2
        else:
            hold=len(merged)//2
            median=merged[hold]
        
        return median