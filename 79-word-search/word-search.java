class Solution {
    int[] delRow={0,-1,0,1};
    int[] delCol={-1,0,1,0};
    int n,m;
    public boolean backTrack(char[][] board,String word,int row,int col,int ind){
        if(ind==word.length())return true;
        char temp=board[row][col];
        board[row][col]='#';
        for(int i=0;i<4;i++){
            int newRow=row+delRow[i];
            int newCol=col+delCol[i];
            if((newRow>=0&&newRow<n)&&(newCol>=0&&newCol<m)&&(word.charAt(ind)==board[newRow][newCol])){
                if(backTrack(board,word,newRow,newCol,ind+1)){
                    board[row][col]=temp;
                    return true;
                }
            }
        }
        board[row][col]=temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        n=board.length;
        m=board[0].length;
        for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j] == word.charAt(0)){
                if(backTrack(board,word,i,j,1)){
                    return true;
                }
            }
        }
        }
        return false;
    }
}