class Solution {
public:
    vector<TreeNode*> generateTrees(int n) {
        if (n == 0) return {};
        return generateTrees(1, n);
    }
    
private:
    vector<TreeNode*> generateTrees(int start, int end) {
        vector<TreeNode*> allTrees;
        if (start > end) {
            allTrees.push_back(nullptr);
            return allTrees;
        }
        
        for (int i = start; i <= end; ++i) {
            vector<TreeNode*> leftTrees = generateTrees(start, i - 1);
            vector<TreeNode*> rightTrees = generateTrees(i + 1, end);
            
            for (TreeNode* left : leftTrees) {
                for (TreeNode* right : rightTrees) {
                    TreeNode* currentTree = new TreeNode(i);
                    currentTree->left = left;
                    currentTree->right = right;
                    allTrees.push_back(currentTree);
                }
            }
        }
        
        return allTrees;
    }
};