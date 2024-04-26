class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (!head || k == 0) return head; // If the list is empty or rotation count is zero, return the list as is
        
        int length = 1; // Length of the linked list
        ListNode *tail = head; // Pointer to the tail of the linked list
        
        // Traverse the list to find the length and the tail node
        while (tail->next) {
            tail = tail->next;
            length++;
        }
        
        // Adjust k to avoid unnecessary rotations
        k = k % length;
        
        // If k is zero, no rotation is needed
        if (k == 0) return head;
        
        // Find the new tail node after rotation
        ListNode *newTail = head;
        for (int i = 1; i < length - k; ++i) {
            newTail = newTail->next;
        }
        
        // Update pointers to perform rotation
        tail->next = head;
        head = newTail->next;
        newTail->next = nullptr;
        
        return head;
    }
};