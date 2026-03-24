class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int[][] ans=new int[grid.length][grid[0].length];
        int mod=12345;
        int m=grid.length;
        int n=grid[0].length;
        long[] prefix=new long[m*n];
        long[] suffix=new long[m*n];
        prefix[0]=grid[0][0]%mod;
        for(int i=1;i<m*n;i++){
            int r=i/n;
            int c=i%n;
            prefix[i]=(prefix[i-1]*grid[r][c])%mod;
        }
        suffix[m*n-1]=grid[m-1][n-1]%mod;
        for(int i=m*n-2;i>=0;i--){
            int r=i/n;
            int c=i%n;
            suffix[i]=(suffix[i+1]*grid[r][c])%mod;
        }
        for(int i=0;i<m*n;i++){
            int r=i/n;
            int c=i%n;
            long left=(i==0)?1:prefix[i-1];
            long right=(i==m*n-1)?1:suffix[i+1];
            ans[r][c]=(int)((left*right)%mod);
        }
        return ans;
    }
}