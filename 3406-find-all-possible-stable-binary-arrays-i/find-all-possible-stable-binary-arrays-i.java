class Solution {
    int MOD = 1000000007;
    int[][][][] ans;

    public int dp(int zero,int one,int last,int count,int limit){
        if(zero==0 && one==0) return 1;

        if(ans[zero][one][last][count] != -1)
            return ans[zero][one][last][count];

        long sum=0;

        if(zero>0){
            if(last==0){
                if(count<limit)
                    sum+=dp(zero-1,one,0,count+1,limit);
            } 
            else{
                sum+=dp(zero-1,one,0,1,limit);
            }
        }

        if(one>0){
            if(last==1){
                if(count<limit)
                    sum+=dp(zero,one-1,1,count+1,limit);
            } 
            else{
                sum+=dp(zero,one-1,1,1,limit);
            }
        }

        ans[zero][one][last][count]=(int)(sum%MOD);
        return ans[zero][one][last][count];
    }

    public int numberOfStableArrays(int zero, int one, int limit) {

        ans=new int[zero+1][one+1][2][limit+1];

        for(int i=0;i<=zero;i++)
            for(int j=0;j<=one;j++)
                for(int k=0;k<2;k++)
                    for(int l=0;l<=limit;l++)
                        ans[i][j][k][l] = -1;

        long res=0;

        if(zero>0)
            res+=dp(zero-1,one,0,1,limit);

        if(one>0)
            res+=dp(zero,one-1,1,1,limit);

        return (int)(res%MOD);
    }
}