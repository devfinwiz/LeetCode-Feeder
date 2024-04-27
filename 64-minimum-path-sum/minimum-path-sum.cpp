class Solution {
public:
    int minPathSum(std::vector<std::vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        // Create a 2D vector to store the minimum path sum
        std::vector<std::vector<int>> dp(m, std::vector<int>(n, 0));
        
        // Initialize the first row and column of dp
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int j = 1; j < n; ++j)
            dp[0][j] = dp[0][j-1] + grid[0][j];
        
        // Fill the dp table iteratively
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                // The minimum path sum to reach dp[i][j] is the sum of the current cell
                // and the minimum of the paths from the top and left
                dp[i][j] = grid[i][j] + std::min(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        // Return the minimum path sum to reach the bottom-right corner
        return dp[m-1][n-1];
    }
};