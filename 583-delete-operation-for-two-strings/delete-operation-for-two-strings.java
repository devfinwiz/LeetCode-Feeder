class Solution {
    public int dp(String word1,String word2,int[][] memo,int i,int j){
        if(i==word1.length()) return word2.length()-j;
        if(j==word2.length()) return word1.length()-i;
        if(memo[i][j]!=-1) return memo[i][j];
        if(word1.charAt(i)==word2.charAt(j)) memo[i][j]=dp(word1,word2,memo,i+1,j+1);
        else{
            memo[i][j]=1+Math.min(dp(word1,word2,memo,i+1,j),dp(word1,word2,memo,i,j+1));
        }
        return memo[i][j];
    }
    public int minDistance(String word1, String word2) {
        int[][] memo=new int[word1.length()][word2.length()];
        for(int [] row:memo){
            Arrays.fill(row,-1);
        }
        return dp(word1,word2,memo,0,0);
    }
}