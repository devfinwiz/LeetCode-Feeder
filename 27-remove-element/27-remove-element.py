class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        k=0
        try:
            while(True):
                        nums.remove(val)
                        k+=1
                        nums.append("_")
        except ValueError:
                pass
        return (len(nums)-k)
        