class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if (!head || !head->next) // If the list is empty or has only one node
            return head;

        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* prev = dummy;
        
        while (prev->next && prev->next->next) {
            ListNode* first = prev->next;
            ListNode* second = first->next;
            
            // Swapping
            prev->next = second;
            first->next = second->next;
            second->next = first;
            
            // Move to the next pair
            prev = first;
        }
        
        ListNode* newHead = dummy->next;
        delete dummy;
        return newHead;
    }
};
