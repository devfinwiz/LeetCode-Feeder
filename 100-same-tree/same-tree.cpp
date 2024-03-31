class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        // Base case: if both nodes are null, they are the same
        if (!p && !q) return true;
        // If one of the nodes is null and the other is not, they are not the same
        if (!p || !q) return false;
        // If values are different, they are not the same
        if (p->val != q->val) return false;
        // Recursively check left and right subtrees
        return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }
};