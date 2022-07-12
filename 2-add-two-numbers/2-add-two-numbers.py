# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
   
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    
        def traverse(list1):
            n1=[]
            while(list1):
                n1.append(list1.val)
                list1=list1.next
            return n1
        
        num1=[]
        num2=[]
        
        num1=traverse(l1)
        num2=traverse(l2)
        
        num1.reverse()
        num2.reverse()
        
        n1string=""
        n2string=""
        for i in num1:
            n1string+=str(i)
        
        for i in num2:
            n2string+=str(i)
            
        n1string=int(n1string)
        n2string=int(n2string)
        
        res=n1string+n2string
        
        res=str(res)
        count=0
        
        resInt=[int(x) for x in res]
        temp=None
        
        
        for val in resInt:
            node=ListNode(val)
            node.next=temp
            temp=node
            
        return temp
        
        
        