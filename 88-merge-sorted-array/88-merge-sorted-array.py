class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if(n==0):
            return
        if(m==0):
            nums1.clear()
            nums1.extend(nums2)
            return
        
        hold=nums1[:m]
        hold.extend(nums2)
        hold.sort()
        
        nums1.clear()
        nums1.extend(hold)
        