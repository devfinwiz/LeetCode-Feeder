class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        
        seen = {}
        for index,val in enumerate(nums):
            if seen.get(val,-1)!=-1 and index-seen[val] <= k:
                return True
            else:
                seen[val] = index
        print(seen)
        return False
        
        
            
            
                
                
            
        
            