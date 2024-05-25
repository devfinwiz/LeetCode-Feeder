class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (!head) return nullptr;

        // Step 1: Create new nodes and insert them next to the original nodes
        Node* curr = head;
        while (curr) {
            Node* newNode = new Node(curr->val);
            newNode->next = curr->next;
            curr->next = newNode;
            curr = newNode->next;
        }

        // Step 2: Assign random pointers for the new nodes
        curr = head;
        while (curr) {
            if (curr->random) {
                curr->next->random = curr->random->next;
            }
            curr = curr->next->next;
        }

        // Step 3: Separate the new nodes to form the copied list
        curr = head;
        Node* copiedHead = head->next;
        Node* copiedCurr = copiedHead;
        while (curr) {
            curr->next = curr->next->next;
            if (copiedCurr->next) {
                copiedCurr->next = copiedCurr->next->next;
            }
            curr = curr->next;
            copiedCurr = copiedCurr->next;
        }

        return copiedHead;
    }
};