class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has one decoding
        dp[1] = s.charAt(0) == '0' ? 0 : 1; // The first character cannot be '0'
        
        for (int i = 2; i <= n; i++) {
            // If the current character is not '0', we can form a single-digit decoding
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            // If the previous character and the current character can be decoded together
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}
