class Solution {
public:
    Node* connect(Node* root) {
        if (!root) return nullptr;

        Node* current = root;
        Node* nextLevelHead = nullptr;  // Head of the next level
        Node* prev = nullptr;  // Previous node to connect

        while (current) {
            while (current) {
                // Check the left child
                if (current->left) {
                    if (prev) {
                        prev->next = current->left;
                    } else {
                        nextLevelHead = current->left;
                    }
                    prev = current->left;
                }

                // Check the right child
                if (current->right) {
                    if (prev) {
                        prev->next = current->right;
                    } else {
                        nextLevelHead = current->right;
                    }
                    prev = current->right;
                }

                // Move to the next node in the current level
                current = current->next;
            }

            // Move to the next level
            current = nextLevelHead;
            nextLevelHead = nullptr;
            prev = nullptr;
        }

        return root;
    }
};