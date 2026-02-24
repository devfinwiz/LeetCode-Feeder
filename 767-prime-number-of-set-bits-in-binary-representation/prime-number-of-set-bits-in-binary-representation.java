class Solution {
    public boolean primeBits(int cnt){
        if(cnt<=1)return false;
        for(int i=2;i<=(int)Math.sqrt(cnt);i++){
            if(cnt%i==0)return false;
        }
        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            String bin=Integer.toBinaryString(i);
            int cnt=0;
            for(char ch:bin.toCharArray()){
                if(ch=='1')cnt++;
            }
            if(primeBits(cnt)) ans++;
        }
        return ans;
    }
}