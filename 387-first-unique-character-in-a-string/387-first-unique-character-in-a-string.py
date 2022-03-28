class Solution:
    def firstUniqChar(self, s: str) -> int:
        hold=[]
        
        for i in s:
            hold.append(i)
            
        hold2=list(dict.fromkeys(hold))
        
        for i in hold2:
            holdindex=hold.index(i)
            hold.remove(i)
            
            if(i not in hold):
                return(holdindex)
            else:
                hold.insert(holdindex,i)
            
        return -1
            