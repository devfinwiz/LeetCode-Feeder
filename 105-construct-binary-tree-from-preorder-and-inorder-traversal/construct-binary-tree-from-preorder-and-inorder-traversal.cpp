class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> inorder_map;
        for (int i = 0; i < inorder.size(); ++i) {
            inorder_map[inorder[i]] = i;
        }
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.size() - 1, inorder_map);
    }
    
    TreeNode* buildTreeHelper(vector<int>& preorder, vector<int>& inorder, int preStart, int inStart, int inEnd, unordered_map<int, int>& inorder_map) {
        if (preStart > preorder.size() - 1 || inStart > inEnd) {
            return nullptr;
        }
        
        TreeNode* root = new TreeNode(preorder[preStart]);
        int inIndex = inorder_map[root->val];
        
        root->left = buildTreeHelper(preorder, inorder, preStart + 1, inStart, inIndex - 1, inorder_map);
        root->right = buildTreeHelper(preorder, inorder, preStart + inIndex - inStart + 1, inIndex + 1, inEnd, inorder_map);
        
        return root;
    }
};