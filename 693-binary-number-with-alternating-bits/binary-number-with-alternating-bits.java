class Solution {
    public boolean hasAlternatingBits(int n) {
        String bin=Integer.toBinaryString(n);
        for(int i=0;i<bin.length()-1;i++){
            if(bin.charAt(i)==bin.charAt(i+1))return false;
        }
        return true;
    }
}