class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        
        count=0
        occurence=len(nums)/2
        
        if(len(nums)==1):
            return nums[0]
        
        distinct=set(nums)
        dup=list(distinct)
        
        for i in dup:
            count=nums.count(i)
            if(count>occurence):
                return i
            else:
                count=0
            
                