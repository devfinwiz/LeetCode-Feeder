class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        if len(s)!=len(goal):
            return False
        elif sorted(s)!=sorted(goal):
            return False
        elif s==goal and len(set(s))==len(goal):
            return False
        else:
            count=0
        for i in range(len(s)):
            if s[i]!=goal[i]:
                count+=1
                if count==3:
                    return False
        return True