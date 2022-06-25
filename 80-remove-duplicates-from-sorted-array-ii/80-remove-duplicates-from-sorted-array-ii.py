class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        count=0
        
        for i in nums:
            count=nums.count(i)
            while(count>2):
                nums.pop(nums.index(i))
                count-=1
            count=0
        
        return len(nums)
            
                