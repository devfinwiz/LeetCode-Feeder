class Solution {
public:
    int uniquePathsWithObstacles(std::vector<std::vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        
        // Create a 2D vector to store the number of unique paths
        std::vector<std::vector<long long>> dp(m, std::vector<long long>(n, 0));
        
        // Initialize the number of paths for the first row and column
        // If there's an obstacle, break the loop
        for (int i = 0; i < m; ++i) {
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            if (obstacleGrid[0][j] == 1)
                break;
            dp[0][j] = 1;
        }
        
        // Fill the dp table iteratively
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 0) {
                    // If the cell is not an obstacle, the number of unique paths to reach dp[i][j]
                    // is the sum of the paths from the top and left
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        // Return the number of unique paths to reach the bottom-right corner
        return dp[m-1][n-1];
    }
};