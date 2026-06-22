class Solution {
    public int dSum(int num){
        int ans=0;
        while(num>0){
            ans=ans+(num%10);
            num/=10;
        }
        return ans;
    }   
    public int sSum(int num){
        int ans=0;
        while(num>0){
            ans+=(int)Math.pow(num%10,2);
            num/=10;
        }
        return ans;
    }
    public boolean checkGoodInteger(int n) {
        if(sSum(n)-dSum(n)>=50)return true;
        return false
        ;
    }
}