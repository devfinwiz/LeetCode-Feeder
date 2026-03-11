class Solution {
    int MOD=1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp=new long[zero+1][one+1][2];
        long[][] preZ=new long[zero+2][one+2];
        long[][] preO=new long[zero+2][one+2];
        for(int z=0; z<=zero; z++) {
            for(int o=0; o<=one; o++) {
                if(z==0 && o==0) {
                    preZ[1][1]=0;
                    preO[1][1]=0;
                    continue;
                }
                if(z==0) {
                    dp[0][o][1]=(o<=limit) ? 1 : 0;
                    dp[0][o][0]=0;
                }
                else if(o==0) {
                    dp[z][0][0]=(z<=limit) ? 1 : 0;
                    dp[z][0][1]=0;
                } 
                else{
                    long lo0=(z-limit-1>=0) ? preZ[z-limit][o] : 0;
                    dp[z][o][0]=(preZ[z][o]-lo0+MOD)%MOD;
                    long lo1=(o-limit-1>=0) ? preO[z][o-limit] : 0;
                    dp[z][o][1]=(preO[z][o]-lo1+MOD)%MOD;
                }
                preZ[z+1][o]=preZ[z][o]+dp[z][o][1];
                preO[z][o+1]=preO[z][o]+dp[z][o][0];
            }
        }
        return (int)((dp[zero][one][0]+dp[zero][one][1])%MOD);
    }
}