class Solution {
public:
    bool hasCycle(ListNode *head) {
        if (head == nullptr || head->next == nullptr)
            return false;
        
        ListNode* slow = head;
        ListNode* fast = head->next;
        
        // Move slow pointer by one step and fast pointer by two steps
        // If there is a cycle, they will eventually meet
        while (slow != fast) {
            if (fast == nullptr || fast->next == nullptr)
                return false;
            slow = slow->next;
            fast = fast->next->next;
        }
        
        return true;
    }
};