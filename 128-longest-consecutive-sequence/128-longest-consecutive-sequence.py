class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums=list(set(nums))
        nums.sort()
        count=0
        maxx=0
        
        if(len(nums)==0):
            return 0
        
        for i in range(0,len(nums)-1):
            if(nums[i+1]-nums[i]==1):
                count+=1
                maxx=max(count,maxx)
            else:
                count=0
        
        return maxx+1
            