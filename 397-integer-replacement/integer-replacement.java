class Solution {
    HashMap<Long, Integer> memo = new HashMap<>();
    public int dp(long n) {
        if (n==1)return 0;
        if (memo.containsKey(n))
            return memo.get(n);
        int ans;
        if(n%2==0){
            ans=1+dp(n/2);
        }
        else{
            ans=1+Math.min(dp(n-1),dp(n+1));
        }
        memo.put(n,ans);
        return ans;
    }
    public int integerReplacement(int n) {
        return dp((long) n);
    }
}
