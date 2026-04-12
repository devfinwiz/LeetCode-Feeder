class Solution{
    int[][][] dp;
    public int getDist(int a,int b){
        int x1=a/6,y1=a%6;
        int x2=b/6,y2=b%6;
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
    public int solve(int idx,int f1,int f2,String word){
        if(idx==word.length()) return 0;
        if(dp[idx][f1][f2]!=-1) return dp[idx][f1][f2];
        int cur=word.charAt(idx)-'A';
        int move1=getDist(f1,cur)+solve(idx+1,cur,f2,word);
        int move2=getDist(f2,cur)+solve(idx+1,f1,cur,word);
        return dp[idx][f1][f2]=Math.min(move1,move2);
    }
    public int minimumDistance(String word){
        int n=word.length();
        dp=new int[n][26][26];
        for(int i=0;i<n;i++){
            for(int j=0;j<26;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                ans=Math.min(ans,solve(0,i,j,word));
            }
        }
        return ans;
    }
}