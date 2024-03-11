class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> result;
        vector<int> currentPath;

        dfs(root, targetSum, currentPath, result);

        return result;
    }

private:
    void dfs(TreeNode* node, int targetSum, vector<int>& currentPath, vector<vector<int>>& result) {
        // Base case: empty tree
        if (node == nullptr) {
            return;
        }

        // Add the current node to the path
        currentPath.push_back(node->val);

        // Check if the current node is a leaf and if the path sum equals targetSum
        if (node->left == nullptr && node->right == nullptr && targetSum - node->val == 0) {
            result.push_back(currentPath);
        }

        // Recursively explore left and right subtrees
        dfs(node->left, targetSum - node->val, currentPath, result);
        dfs(node->right, targetSum - node->val, currentPath, result);

        // Backtrack: remove the current node from the path
        currentPath.pop_back();
    }
};