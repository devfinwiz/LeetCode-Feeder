class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* current = head;

        while (current != nullptr && current->next != nullptr) {
            if (current->val == current->next->val) {
                // Duplicate found, remove the duplicate node
                ListNode* duplicate = current->next;
                current->next = current->next->next;
                delete duplicate;
            } else {
                // Move to the next node
                current = current->next;
            }
        }

        return head;
    }
};