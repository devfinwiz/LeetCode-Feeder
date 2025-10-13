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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode first = list1;
        ListNode second  = list1;
        int count = 0;
        while(count < a-1){
            first = first.next;
            count++;
        }
        count = 0;
        while(count < b){
            second = second.next;
            count++;
        }
        ListNode secondLast = list2;
        while(secondLast.next!=null){
            secondLast = secondLast.next;
        }
        first.next = list2;
        secondLast.next = second.next;
        return list1;
    }
}