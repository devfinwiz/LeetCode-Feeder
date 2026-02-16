class Solution {
    public void intToBin(int n, StringBuilder sb) {
        int x = n;
        for (int i = 0; i < 32; i++) {
            sb.append(x % 2);
            x = x / 2;
        }
    }
    public int binToInt(StringBuilder sb) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            int bit = sb.charAt(i) - '0';
            if (bit == 1) {
                num += (int) Math.pow(2, 31 - i);
            }
        }
        return num;
    }
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        intToBin(n, sb);
        return binToInt(sb);
    }
}
