class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> nodeStack;
        
        if (root == nullptr)
            return result;
        
        nodeStack.push(root);
        
        while (!nodeStack.empty()) {
            TreeNode* current = nodeStack.top();
            nodeStack.pop();
            
            result.push_back(current->val);
            
            if (current->right)
                nodeStack.push(current->right);
            if (current->left)
                nodeStack.push(current->left);
        }
        
        return result;
    }
};