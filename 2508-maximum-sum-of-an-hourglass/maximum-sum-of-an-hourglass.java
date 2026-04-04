class Solution {
    public int maxSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] pref = new int[n][m];
        for(int i = 0; i < n; i++){
            pref[i][0] = grid[i][0];
            for(int j = 1; j < m; j++){
                pref[i][j] = pref[i][j-1] + grid[i][j];
            }
        }
        int maxxSum = Integer.MIN_VALUE;
        for(int i = 0; i <= n - 3; i++){
            for(int j = 0; j <= m - 3; j++){
                int top = pref[i][j+2] - (j > 0 ? pref[i][j-1] : 0);
                int mid = grid[i+1][j+1];
                int bottom = pref[i+2][j+2] - (j > 0 ? pref[i+2][j-1] : 0);
                int total = top + mid + bottom;
                maxxSum = Math.max(maxxSum, total);
            }
        }
        return maxxSum;
    }
}