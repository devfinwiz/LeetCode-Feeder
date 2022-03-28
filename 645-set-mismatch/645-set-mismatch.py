from collections import Counter
class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        count=Counter(nums)
        count=dict(count)
        res=[]
        
        hold=list(count.keys())
            
        for i,j in count.items():
            if(j==2):
                res.append(i)
                hold.append(i)
        
        mini=min(hold)
        maxi=max(hold)
        hold2=[]
        
        for i in range(mini,maxi+1):
            hold2.append(i)
        
        if(1 not in hold):
            res.append(1)
            return res
        
        for i in hold2:
            if(i not in hold):
                res.append(i)
                return res
        
        res.append(maxi+1)
        
        return res
               
        
