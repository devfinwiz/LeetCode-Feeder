class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board=[["." for i in range(n)] for i in range(n)]
        res=[]
        
        def issafe(board,row,col):
            #columns over
            for i in range(row,-1,-1):
                if(board[i][col]=="Q"):
                    return False

            #top left diagonals
            for i,j in zip(range(row,-1,-1),range(col,-1,-1)):
                if(board[i][j]=="Q"):
                    return False

            #top right diagonals
            for i,j in zip(range(row,-1,-1),range(col,n)):
                if(board[i][j]=="Q"):
                    return False

            return True
        
        def addresults(currboard):
            curr = []
            for i in range(n):
                curr.append("".join(board[i]))
            res.append(curr)
            
        def nqueens(board,row):
            if(row>=n):
                addresults(board)
                return True
            
            for i in range(n):
                if(issafe(board,row,i)):
                    board[row][i]="Q"
                    nqueens(board,row+1)
                    board[row][i]="."
            return False

        if(nqueens(board,0)):
            for i in board:
                print(i,end='')
        
            
        return res
        