class Solution {
    int[] delRow=new int[]{0,-1,0,1};
    int[] delCol=new int[]{-1,0,1,0};
    int n,m;
    public int dfs(int i,int j,int[][] matrix,int[][] visited){
        if(visited[i][j]!=0)return visited[i][j];
        int maxxlen=1;
        for(int k=0;k<4;k++){
            int newRow=delRow[k]+i;
            int newCol=delCol[k]+j;
            if((newRow>=0&&newRow<n)&&(newCol>=0&&newCol<m)){
                if(matrix[i][j]<matrix[newRow][newCol]){
                    int len=1+dfs(newRow,newCol,matrix,visited);
                    maxxlen=Math.max(maxxlen,len);
                }
            }
        }
        visited[i][j]=maxxlen;
        return maxxlen;
    }
    public int longestIncreasingPath(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        int[][] visited=new int[matrix.length][matrix[0].length];
        for(int[] row:visited){
            Arrays.fill(row,0);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dfs(i,j,matrix,visited);
            }
        }
        int maxxDistance=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxxDistance=Math.max(maxxDistance,visited[i][j]);
            }
        }
        return maxxDistance;
    }
}