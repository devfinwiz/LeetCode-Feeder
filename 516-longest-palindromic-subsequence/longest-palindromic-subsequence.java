class Solution {
    public int memo(int[][] dp, String text1, String text2, int len1,int len2){
        if(len1<0 || len2<0) return 0;
        if(dp[len1][len2]!=-1) return dp[len1][len2];
        if(text1.charAt(len1) == text2.charAt(len2)) return 1+memo(dp,text1,text2,len1-1,len2-1);
        return dp[len1][len2] = Math.max(memo(dp,text1,text2,len1-1,len2),memo(dp,text1,text2,len1,len2-1));
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(s);
        String t = sb1.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String s1 = sb.toString();
        int[][] dp = new int[s1.length()][t.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return memo(dp,s1,t,s1.length()-1,t.length()-1);
    }
}