class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        // Create a hashmap to store indices of elements in the inorder traversal
        unordered_map<int, int> inorder_map;
        for (int i = 0; i < inorder.size(); ++i) {
            inorder_map[inorder[i]] = i;
        }
        // Call the helper function to construct the binary tree
        return buildTreeHelper(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1, inorder_map);
    }

private:
    TreeNode* buildTreeHelper(const vector<int>& inorder, int inStart, int inEnd,
                               const vector<int>& postorder, int postStart, int postEnd,
                               unordered_map<int, int>& inorder_map) {
        if (inStart > inEnd || postStart > postEnd) {
            return nullptr;
        }
        
        // The last element in the postorder traversal is the root node
        int rootVal = postorder[postEnd];
        TreeNode* root = new TreeNode(rootVal);
        
        // Find the index of the root node in the inorder traversal
        int rootIndexInInorder = inorder_map[rootVal];
        
        // Calculate the size of the left subtree
        int leftSubtreeSize = rootIndexInInorder - inStart;
        
        // Recursively construct left and right subtrees
        root->left = buildTreeHelper(inorder, inStart, rootIndexInInorder - 1,
                                      postorder, postStart, postStart + leftSubtreeSize - 1,
                                      inorder_map);
        root->right = buildTreeHelper(inorder, rootIndexInInorder + 1, inEnd,
                                       postorder, postStart + leftSubtreeSize, postEnd - 1,
                                       inorder_map);
        
        return root;
    }
};