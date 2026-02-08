class Solution {
    public int minimumDeletions(String s) {
        int[] cnt=new int[s.length()];
        int cntA=0;
        for(int i=s.length()-1;i>=0;i--){
            cnt[i]=cntA;
            if(s.charAt(i)=='a')cntA++;
        }
        int minn=s.length();
        int cntB=0;
        for(int i=0;i<s.length();i++){
            minn=Math.min(cntB+cnt[i],minn);
            if(s.charAt(i)=='b') cntB++;
        }
        return minn;
    }
}