class Solution {
public:
    Node* connect(Node* root) {
        if (!root) return nullptr;

        Node* leftmost = root;

        while (leftmost->left) {
            Node* head = leftmost;
            
            while (head) {
                // Connect the left child to the right child
                head->left->next = head->right;
                
                // Connect the right child to the next subtree's left child
                if (head->next) {
                    head->right->next = head->next->left;
                }
                
                // Move to the next node in the current level
                head = head->next;
            }
            
            // Move to the next level
            leftmost = leftmost->left;
        }

        return root;
    }
};