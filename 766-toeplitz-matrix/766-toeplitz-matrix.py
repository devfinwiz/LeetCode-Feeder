class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
       
        n,m=len(matrix),len(matrix[0])
        
        for i in range(0,n-1):
            for j in range(0,m-1):
                if(matrix[i][j]!=matrix[i+1][j+1]):
                    return False
        
        return True
                
        