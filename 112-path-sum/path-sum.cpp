class Solution {
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        // Base case: empty tree
        if (root == nullptr) {
            return false;
        }

        // Check if the current node is a leaf and if the path sum equals targetSum
        if (root->left == nullptr && root->right == nullptr) {
            return (targetSum - root->val == 0);
        }

        // Recursively check for the targetSum in the left and right subtrees
        bool leftPath = hasPathSum(root->left, targetSum - root->val);
        bool rightPath = hasPathSum(root->right, targetSum - root->val);

        return leftPath || rightPath;
    }
};