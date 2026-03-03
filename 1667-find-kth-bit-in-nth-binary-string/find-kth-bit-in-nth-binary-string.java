class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";
        for(int i = 2; i <= n; i++){
            StringBuilder invertOfPrev = new StringBuilder();
            for(char bit : s.toCharArray()){
                invertOfPrev.append( (bit == '0') ? '1' : '0' );
            }
            s = s + "1" + invertOfPrev.reverse().toString();
        }
        return s.charAt(k - 1);
    }
}