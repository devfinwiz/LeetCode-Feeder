class Solution {
public:
    int numTrees(int n) {
        // Create a DP array to store the number of unique BSTs for each count of nodes
        vector<int> dp(n + 1, 0);
        
        // There is one unique BST with 0 nodes (an empty tree)
        dp[0] = 1;
        // There is one unique BST with 1 node
        dp[1] = 1;
        
        // Fill the DP array
        for (int nodes = 2; nodes <= n; ++nodes) {
            for (int root = 1; root <= nodes; ++root) {
                // The number of unique BSTs with 'nodes' nodes is the sum of
                // the number of unique BSTs formed by each possible root node
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }
        
        return dp[n];
    }
};
