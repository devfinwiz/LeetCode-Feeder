class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        if (!head) return nullptr;
        if (!head->next) return new TreeNode(head->val);
        
        ListNode *slow = head, *fast = head, *prev = nullptr;
        
        // Use two-pointer technique to find the middle of the list
        while (fast && fast->next) {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        
        // Disconnect the left half from the mid node
        if (prev) prev->next = nullptr;
        
        // slow is now pointing to the middle node
        TreeNode* root = new TreeNode(slow->val);
        
        // Recursively build the left and right subtrees
        if (head != slow) // to handle the case when slow is still head
            root->left = sortedListToBST(head);
        root->right = sortedListToBST(slow->next);
        
        return root;
    }
};
