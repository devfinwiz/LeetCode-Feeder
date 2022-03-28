class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        maximum=max(num1,num2)
        minimum=min(num1,num2)
        
        hold=int(maximum)+int(minimum)
        
        return str(hold)