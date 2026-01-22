class Solution {
    public void dfs(int[][] grid,int[][] visited,int row,int col,int[] delRow,int[] delCol,int n,int m){
        visited[row][col]=1;
        for(int i=0;i<4;i++){
            int newRow=row+delRow[i];
            int newCol=col+delCol[i];
            if(newRow>=0&&newRow<n&&newCol>=0&&newCol<m&&grid[newRow][newCol]==1&&visited[newRow][newCol]==-1){
                dfs(grid,visited,newRow,newCol,delRow,delCol,n,m);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        for(int[]row:visited){
            Arrays.fill(row,-1);
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        for(int i=0;i<n;i++){
            if(grid[i][0]==1&&visited[i][0]==-1){
                dfs(grid,visited,i,0,delRow,delCol,n,m);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][m-1]==1&&visited[i][m-1]==-1){
                dfs(grid,visited,i,m-1,delRow,delCol,n,m);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[0][i]==1&&visited[0][i]==-1){
                dfs(grid,visited,0,i,delRow,delCol,n,m);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[n-1][i]==1&&visited[n-1][i]==-1){
                dfs(grid,visited,n-1,i,delRow,delCol,n,m);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&visited[i][j]==-1){
                    count++;
                }
            }
        }
        return count;
    }
}