class Solution {
    public String convertToBinary(int i) {
        StringBuilder str = new StringBuilder();
        while (i > 0) {
            str.append(i % 2);
            i = i / 2;
        }
        return str.reverse().toString();
    }

    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long num = 0;
        for (int i = 1; i <= n; i++) {
            String bin = convertToBinary(i);
            for (int j = 0; j < bin.length(); j++) {
                num = (num * 2 + (bin.charAt(j) - '0')) % MOD;
            }
        }
        return (int) num;
    }
}
