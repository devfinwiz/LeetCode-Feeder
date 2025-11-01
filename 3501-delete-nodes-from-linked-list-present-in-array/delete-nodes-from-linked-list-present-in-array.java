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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int digit:nums){
            map.put(digit,map.getOrDefault(digit,0)+1);
        }
        ListNode temp = head;
        ListNode newHead = null;
        ListNode newTail = null;
        while(temp!=null){
            if(!map.containsKey(temp.val)){
                ListNode newNode = new ListNode(temp.val);
                if(newHead == null){
                    newHead = newTail = newNode;
                }
                else{
                    newTail.next = newNode;
                    newTail = newNode;
                }
            }
            temp = temp.next;
        }
        return newHead;
    }
}