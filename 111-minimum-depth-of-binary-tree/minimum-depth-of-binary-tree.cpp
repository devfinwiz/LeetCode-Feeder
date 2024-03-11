class Solution {
public:
    int minDepth(TreeNode* root) {
        // Base case: empty tree has depth 0
        if (root == nullptr) {
            return 0;
        }

        // Use level order traversal (BFS) to find the minimum depth
        queue<TreeNode*> q;
        q.push(root);
        int depth = 1;

        while (!q.empty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; ++i) {
                TreeNode* current = q.front();
                q.pop();

                // Check if the current node is a leaf node
                if (current->left == nullptr && current->right == nullptr) {
                    return depth;
                }

                // Add child nodes to the queue
                if (current->left) {
                    q.push(current->left);
                }
                if (current->right) {
                    q.push(current->right);
                }
            }

            // Move to the next level
            ++depth;
        }

        return depth;
    }
};