class Solution {
    public int numSub(String s) {
        long sum=0;
        int mod=1_000_000_007;
        int low=0;
        int high=0;
        while(high<s.length()){
            if(s.charAt(high)=='1'){
                high++;
            }
            else{
                long len=high-low;
                sum=(sum+(len*(len+1))/2)%mod;
                high++;
                low=high;
            }
        }
        long len=high-low;
        sum=(sum+(len*(len+1))/2)%mod;
        return (int) sum;
    }
}
