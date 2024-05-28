class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        if (!head || !head->next) return head;

        ListNode* sorted = new ListNode(0); // Dummy node as the new head of the sorted list
        ListNode* current = head;

        while (current) {
            ListNode* prev = sorted;
            ListNode* next = sorted->next;

            // Find the position to insert the current node
            while (next) {
                if (current->val < next->val) break;
                prev = next;
                next = next->next;
            }

            // Insert the current node in the new list
            ListNode* temp = current->next;
            current->next = next;
            prev->next = current;
            current = temp;
        }

        ListNode* newHead = sorted->next;
        delete sorted; // Free the dummy node
        return newHead;
    }
};