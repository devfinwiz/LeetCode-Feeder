class Solution {
    public int dp(String s,int[][] memo,int i,int j){
        if(i>=j) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        if(s.charAt(i)==s.charAt(j)){
            memo[i][j]=dp(s,memo,i+1,j-1);
        }
        else{
            memo[i][j]=1+Math.min(dp(s,memo,i+1,j),dp(s,memo,i,j-1));
        }
        return memo[i][j];
    }
    public int minInsertions(String s) {
        int[][] memo=new int[s.length()][s.length()];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dp(s,memo,0,s.length()-1);
    }
}