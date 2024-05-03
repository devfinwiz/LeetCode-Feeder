class Solution {
public:
    int minDistance(std::string word1, std::string word2) {
        int m = word1.size();
        int n = word2.size();
        
        // Create a 2D vector to store the minimum number of operations
        std::vector<std::vector<int>> dp(m + 1, std::vector<int>(n + 1, 0));
        
        // Initialize the first row and column
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; ++j) {
            dp[0][j] = j;
        }
        
        // Fill in the DP table
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + std::min({dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]});
                }
            }
        }
        
        return dp[m][n];
    }
};