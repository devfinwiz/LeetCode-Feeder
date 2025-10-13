class Solution {
    public int dp(int[][] memo, int[][] mat,int index, int val,int target){
        if(index == mat.length) return Math.abs(val-target);
        if(memo[index][val] != -1) return memo[index][val];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            ans = Math.min(ans, dp(memo, mat, index + 1, val + mat[index][i], target));
        }
        return memo[index][val] = ans;
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int[][] memo = new int[mat.length][5001];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dp(memo, mat,0, 0, target);
    }
}