class Solution {
    public int mirrorFrequency(String s) {
        int chars[] = new int[26];
        int digits[] = new int[10];
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits[ch - '0']++;
            }
            else {
                chars[ch - 'a']++;
            }
        }
        int ans = 0;
        for (int i = 0, j = 9; i < j; i++, j--) {
            ans += Math.abs(digits[i] - digits[j]);
        }
        for (int i = 0, j = 25; i < j; i++, j--) {
            ans += Math.abs(chars[i] - chars[j]);
        }
        return ans;
    }
}