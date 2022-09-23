class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        seen,res=set(),set()
        count=0
        for i in range(len(s)):
            count+=1
            curr=s[i:i+10]
            
            if(curr in seen):
                res.add(curr)
            seen.add(curr)
        print(count)
        return list(res)