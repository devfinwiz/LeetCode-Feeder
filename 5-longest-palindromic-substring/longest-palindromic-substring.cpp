class Solution {
public:
    std::string longestPalindrome(std::string s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        // dp[i][j] is true if the substring s[i...j] is a palindrome
        std::vector<std::vector<bool>> dp(n, std::vector<bool>(n, false));

        int start = 0;  // Start index of the longest palindrome
        int maxLength = 1;  // Length of the longest palindrome

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; ++i) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check substrings of length 3 or more
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;

                // Check if the current substring is a palindrome
                if (dp[i + 1][j - 1] && s[i] == s[j]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        return s.substr(start, maxLength);
    }
};