class Solution {
    public int binaryGap(int n) {
        String bin=Integer.toBinaryString(n);
        int prev=-1;
        int maxx=0;
        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i)=='1'){
                if(prev!=-1){
                    maxx=Math.max(maxx,i-prev);
                }
                prev=i;
            }
        }
        return maxx;
    }
}