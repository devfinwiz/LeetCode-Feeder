class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> nodes;
        TreeNode* prev = nullptr;

        while (root != nullptr || !nodes.empty()) {
            while (root != nullptr) {
                nodes.push(root);
                root = root->left;
            }

            root = nodes.top();
            if (root->right == nullptr || root->right == prev) {
                result.push_back(root->val);
                nodes.pop();
                prev = root;
                root = nullptr;
            } else {
                root = root->right;
            }
        }

        return result;
    }
};