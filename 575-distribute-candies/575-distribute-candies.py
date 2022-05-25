class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        count=len(candyType)//2
        
        types=list(set(candyType))
        
        if(len(types)<count):
            return len(types)
        else:
            return count