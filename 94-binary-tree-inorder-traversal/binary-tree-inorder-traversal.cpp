class Solution {
public:
    std::vector<int> inorderTraversal(TreeNode* root) {
        std::vector<int> result;
        std::stack<TreeNode*> stack;
        TreeNode* current = root;
        
        while (current != nullptr || !stack.empty()) {
            // Traverse left subtree
            while (current != nullptr) {
                stack.push(current);
                current = current->left;
            }
            
            // Process current node and move to right subtree
            current = stack.top();
            stack.pop();
            result.push_back(current->val);
            current = current->right;
        }
        
        return result;
    }
};