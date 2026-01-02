class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        new_str=""
        new_str1=""
        for i in digits:
            new_str+=str(i)
        new_str1=int(new_str)+1
        new_lst=[]
        for i in str(new_str1):
            new_lst.append(int(i))
        return new_lst
            
        
        