class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] facts=new int[10];
        facts[0]=1;
        for(int i=1;i<=9;i++){
            facts[i]=facts[i-1]*i;
        }
        int sum=0;
        int x=n;
        int temp=n;
        while(n>0){
            int rem=n%10;
            sum+=facts[rem];
            n=n/10;
        }
        int[] freq=new int[10];
        while(temp>0){
            freq[temp%10]++;
            temp/=10;
        }
        while(sum>0){
            freq[sum%10]--;
            sum/=10;
        }
        for(int f:freq){
            if(f!=0)return false;
        }
        return true;
    }
}