class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        heven=[x for x in nums if x%2==0]
        hodd=[y for y in nums if y%2!=0]
        
        heven.extend(hodd)
        return heven