class Solution {
public:
    bool isBalanced(TreeNode* root) {
        return checkBalance(root) != -1;
    }

private:
    int checkBalance(TreeNode* node) {
        if (node == nullptr) {
            return 0; // Height of an empty tree is 0
        }

        int leftHeight = checkBalance(node->left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced
        }

        int rightHeight = checkBalance(node->right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced
        }

        int heightDiff = std::abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return -1; // Current subtree is unbalanced
        }

        return 1 + std::max(leftHeight, rightHeight); // Return the height of the current subtree
    }
};