class Solution {
    public int numOfWays(int n) {
        int MOD = 1000000007;
        long a=6;
        long b=6;
        for(int i=2;i<=n;i++){
            long aa=(3*a+2*b)%MOD;
            long bb=(2*a+2*b)%MOD;
            a=aa;
            b=bb;
        }
        return (int)((a+b)%MOD);
    }
}