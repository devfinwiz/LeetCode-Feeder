class Solution {
    public void dfs(char[][] grid,int[][] visited,Boolean[][]parent,int[]delRow,int[] delCol,int row,int col,int prevRow,int prevCol){
        visited[row][col]=1;
        for(int i=0;i<4;i++){
            int newRow=row+delRow[i];
            int newCol=col+delCol[i];
            if(newRow>=0&&newRow<grid.length&&newCol>=0&&newCol<grid[0].length&&grid[row][col]==grid[newRow][newCol]){
                if(visited[newRow][newCol]==-1){
                    dfs(grid,visited,parent,delRow,delCol,newRow,newCol,row,col);
                }
                else if(newRow!=prevRow&&newCol!=prevCol){
                    parent[newRow][newCol]=true;
                }
            }
        }
    }
    public boolean containsCycle(char[][] grid) {
        Boolean[][] parent=new Boolean[grid.length][grid[0].length];
        int[][] visited=new int[grid.length][grid[0].length];
        int[] delRow={0,-1,0,1};
        int[] delCol={-1,0,1,0};
        for(int[] row:visited){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==-1){
                    dfs(grid,visited,parent,delRow,delCol,i,j,-1,-1);
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(parent[i][j]==null)continue;
                else if(parent[i][j]==true)return true;
            }
        }
        return false;
    }
}