from collections import Counter
class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        hold=[x for x in nums if(x%2==0)]
        if(len(hold)==0):
            return -1
        print(sorted(hold))
        return max(sorted(hold), key=hold.count)