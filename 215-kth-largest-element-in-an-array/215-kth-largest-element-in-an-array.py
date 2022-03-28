class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        for i in range(0,k):
            maxi=max((nums))
            nums.pop(nums.index(maxi))
            
        return maxi