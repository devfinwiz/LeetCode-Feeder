class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        
        res=[]
        hold=[]
        for i in image:
            i=i[::-1]
            hold.append(i) 
        
        for i in hold:
            for j in range(0,len(i)):
                if(i[j]==1):
                    i[j]=0
                elif(i[j]==0):
                    i[j]=1
                    
        return hold
        
        