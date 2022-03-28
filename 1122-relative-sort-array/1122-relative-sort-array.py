class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        count=[]
        res=[]
        holder=[]
        
        for i in arr2:
            count.append(arr1.count(i))
            
        for i in range(len(arr2)):
            hold=count[i]
            res.extend([arr2[i]]*hold)
            
        for i in arr1:
            if(i not in arr2):
                holder.append(i)
                
        holder.sort()
        
        for i in holder:
            res.append(i)
        return res