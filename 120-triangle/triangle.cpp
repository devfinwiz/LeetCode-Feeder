
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        
        // Initialize the dp vector with the bottom row of the triangle
        vector<int> dp(triangle.back());

        // Start from the second to the last row and update the dp vector
        for (int row = n - 2; row >= 0; --row) {
            for (int i = 0; i <= row; ++i) {
                // Choose the minimum path from the two adjacent numbers in the row below
                dp[i] = triangle[row][i] + min(dp[i], dp[i + 1]);
            }
        }

        return dp[0];
    }
};