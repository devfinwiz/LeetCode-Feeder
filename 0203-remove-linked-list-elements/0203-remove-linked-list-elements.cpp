class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        // Create a dummy node which will help us handle edge cases easily
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* current = dummy;

        // Traverse the list
        while (current->next != nullptr) {
            if (current->next->val == val) {
                // Skip the node with the value equal to val
                ListNode* nodeToRemove = current->next;
                current->next = current->next->next;
                delete nodeToRemove;
            } else {
                // Move to the next node
                current = current->next;
            }
        }

        // The new head of the list is next of dummy node
        ListNode* newHead = dummy->next;
        delete dummy;
        return newHead;
    }
};