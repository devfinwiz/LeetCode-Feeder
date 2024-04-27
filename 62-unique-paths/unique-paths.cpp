class Solution {
public:
    int uniquePaths(int m, int n) {
        // Create a 2D vector to store the number of unique paths
        std::vector<std::vector<int>> dp(m, std::vector<int>(n, 0));
        
        // Initialize the number of paths for the first row and column to 1
        for (int i = 0; i < m; ++i)
            dp[i][0] = 1;
        for (int j = 0; j < n; ++j)
            dp[0][j] = 1;
        
        // Fill the dp table iteratively
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                // The number of unique paths to reach dp[i][j] is the sum of the paths from the top and left
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        // Return the number of unique paths to reach the bottom-right corner
        return dp[m-1][n-1];
    }
};