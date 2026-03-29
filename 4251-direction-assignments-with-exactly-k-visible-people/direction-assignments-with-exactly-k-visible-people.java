class Solution {
    int MOD=1_000_000_007;
    public long cr(int n,int r){
        if(r<0||r>n)return 0;
        long numer=1;
        long deno=1;
        for(int i=1;i<=r;i++){
            numer=numer*(n-i+1)%MOD;
            deno=deno*i%MOD;
        }
        return numer*inv(deno)%MOD;
    }
    public long inv(long a){
        return power(a,MOD-2);
    }
    public long power(long a,long b){
        long res=1;
        a%=MOD;
        while(b>0){
            if((b&1)==1){
                res=res*a%MOD;
            }
            a=a*a%MOD;
            b>>=1;
        }
        return res;
    }
    public int countVisiblePeople(int n, int pos, int k) {
        return (int)(2*cr(n-1,k)%MOD);
    }
}