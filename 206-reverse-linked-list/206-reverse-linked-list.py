# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        def traverse(list1):
            n1=[]
            while(list1):
                n1.append(list1.val)
                list1=list1.next
            return n1
        
        li=traverse(head)
        
        temp=None
        for i in li:
            node=ListNode(i)
            node.next=temp
            temp=node
            
        return temp
        
        