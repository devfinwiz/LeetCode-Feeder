class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        s1=set(nums1)
        s2=set(nums2)
        
        answer=[]
        
        answer.append(s1.difference(s2))
        answer.append(s2.difference(s1))
        
        return answer