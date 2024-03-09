class Solution {
public:
    // Recursive approach
    bool isSymmetricRecursive(TreeNode* left, TreeNode* right) {
        if (!left && !right) {
            return true;
        }
        if (!left || !right) {
            return false;
        }
        
        return (left->val == right->val) &&
               isSymmetricRecursive(left->left, right->right) &&
               isSymmetricRecursive(left->right, right->left);
    }
    
    bool isSymmetric(TreeNode* root) {
        if (!root) {
            return true;
        }
        
        return isSymmetricRecursive(root->left, root->right);
    }

    // Iterative approach
    bool isSymmetricIterative(TreeNode* root) {
        if (!root) {
            return true;
        }

        queue<TreeNode*> q;
        q.push(root->left);
        q.push(root->right);

        while (!q.empty()) {
            TreeNode* leftNode = q.front();
            q.pop();
            TreeNode* rightNode = q.front();
            q.pop();

            if (!leftNode && !rightNode) {
                continue;
            }
            if (!leftNode || !rightNode) {
                return false;
            }
            if (leftNode->val != rightNode->val) {
                return false;
            }

            q.push(leftNode->left);
            q.push(rightNode->right);
            q.push(leftNode->right);
            q.push(rightNode->left);
        }

        return true;
    }
};