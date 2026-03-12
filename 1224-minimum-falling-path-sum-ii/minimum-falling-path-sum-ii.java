class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<m;i++){
            dp[n-1][i]=grid[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<m;j++){
                int minn=Integer.MAX_VALUE;
                for(int k=0;k<m;k++){
                    if(j!=k){
                        minn=Math.min(minn,dp[i+1][k]);
                    }
                }
                dp[i][j]=grid[i][j]+minn;
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans=Math.min(ans,dp[0][i]);
        }
        return ans;
    }
}