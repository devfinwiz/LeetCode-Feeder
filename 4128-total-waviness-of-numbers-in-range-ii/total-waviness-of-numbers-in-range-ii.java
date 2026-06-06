 class Solution {
Long[][][][][][] dp;
public long totalWaviness(long num1, long num2) {
    String r = num2 + "";
    long right;
    dp = new Long[r.length() + 1][2][20][11][11][2];
    right = call(r, 0, 1, 0, 10, 10, 1);
    long left = 0;
    if (num1 > 0) {
        String l = (num1 - 1) + "";
        dp = new Long[l.length() + 1][2][20][11][11][2];
        left = call(l, 0, 1, 0, 10, 10, 1);
    }
    return right - left;
}
public long call(String s, int idx, int tight, int count,
                 int prev1, int prev2, int lz) {
    if (idx == s.length()) {
        return count;
    }
    if (dp[idx][tight][count][prev1][prev2][lz] != null) {
        return dp[idx][tight][count][prev1][prev2][lz];
    }
    int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
    long ans = 0;
    for (int k = 0; k <= ub; k++) {
        int nextTight = (tight == 1 && k == ub) ? 1 : 0;
        if (lz == 1 && k == 0) {
            ans += call(s, idx + 1, nextTight, count, 10, 10, 1);
        } 
        else if (lz == 1 && k > 0) {
            ans += call(s, idx + 1, nextTight, count, k, 10, 0);
        } 
        else if (prev2 == 10) {
            ans += call(s, idx + 1, nextTight, count, k, prev1, 0);
        } 
        else{
            int score = 0;
            if (prev2 < prev1 && prev1 > k) {
                score = 1;
            }
            else if (prev2 > prev1 && prev1 < k) {
                score = 1;
            }
            ans += call(s, idx + 1, nextTight, count + score, k, prev1, 0);
        }
    }
    return dp[idx][tight][count][prev1][prev2][lz] = ans;
}}