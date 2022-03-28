class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack=list()
        for i in s:
            if(i=="("):
                stack.append(i)
            elif(i=="{"):
                stack.append(i)
            elif(i=="["):
                stack.append(i)
            elif(i==")" and len(stack)!=0 and stack[-1]=="("):
                stack.pop()
            elif(i=="]" and len(stack)!=0 and stack[-1]=="["):
                stack.pop()
            elif(i=="}" and len(stack)!=0 and stack[-1]=="{"):
                stack.pop()
            else:
                return False
            
        return stack==[]
                
        
        