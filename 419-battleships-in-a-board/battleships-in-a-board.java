class Solution {
    public void dfs(int[][]visited,char[][]board,int prevI,int prevJ,int i,int j,int[]delRow,int[]delCol,int n,int m){
        if(prevI==i&&prevJ==j){
            visited[i][j]=1;
        }
        else{
            visited[i][j]=1;
        }
        for(int k=0;k<4;k++){
            int newRow=i+delRow[k];
            int newCol=j+delCol[k];
            if(newRow >= 0 && newRow < n &&newCol >= 0 && newCol < m &&board[newRow][newCol] == 'X' &&visited[newRow][newCol] == Integer.MAX_VALUE){
                prevI=i;
                prevJ=j;
                dfs(visited,board,prevI,prevJ,newRow,newCol,delRow,delCol,n,m);
            }
        }
    }
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] visited=new int[n][m];
        int count=0;
        for(int[] row:visited){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        int prevI;
        int prevJ;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X' && visited[i][j]==Integer.MAX_VALUE){
                    visited[i][j]=1;
                    count++;
                    prevI=i;
                    prevJ=j;
                    dfs(visited,board,prevI,prevJ,i,j,delRow,delCol,n,m);
                }
            }
        }
        return count;
    }
}