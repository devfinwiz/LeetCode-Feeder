class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        n1=0
        n2=0
        
        for i in num1:
            n1=ord(i)-48+n1*10
        for i in num2:
            n2=ord(i)-48+n2*10
            
        return str(n1*n2)