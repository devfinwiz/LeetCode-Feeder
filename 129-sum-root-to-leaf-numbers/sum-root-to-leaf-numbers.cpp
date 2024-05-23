class Solution {
public:
    int sumNumbers(TreeNode* root) {
        return dfs(root, 0);
    }
    
    int dfs(TreeNode* node, int currentSum) {
        if (node == nullptr) return 0;
        
        currentSum = currentSum * 10 + node->val;
        
        if (node->left == nullptr && node->right == nullptr) {
            return currentSum;
        }
        
        return dfs(node->left, currentSum) + dfs(node->right, currentSum);
    }
};