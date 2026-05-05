/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int length = 1;
        ListNode temp = head;
        while(temp.next!=null){
            length++;
            temp = temp.next;
        }
        ListNode tail = temp;
        tail.next = head;
        if(k % length == 0){tail.next = null;return head;}
        int limit = length - (k%length);
        int i = 1;
        while(i < limit+1){
            temp = temp.next;
            i++;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        return newHead;
    }
}