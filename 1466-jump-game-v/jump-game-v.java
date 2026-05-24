class Solution {
    int[] memo;
    public int dp(int[] arr,int d,int i){
        if(memo[i]!=-1)return memo[i];
        int result=1;
        for(int j=i-1;j>=Math.max(0,i-d);j--){
            if(arr[j]>=arr[i]) break;
            result=Math.max(result,1+dp(arr,d,j));
        }
        for(int j=i+1;j<=Math.min(arr.length-1,i+d);j++){
            if(arr[j]>=arr[i])break;
            result=Math.max(result,1+dp(arr,d,j));
        }
        return memo[i]=result;
    }
    public int maxJumps(int[] arr, int d) {
        memo=new int[arr.length];
        Arrays.fill(memo,-1);
        int maxx=-1;
        for(int i=0;i<arr.length;i++){
            maxx=Math.max(maxx,dp(arr,d,i));
        }
        return maxx;
    }
}