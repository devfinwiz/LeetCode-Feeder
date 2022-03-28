class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        
        for i in ransomNote:
            if(ransomNote.count(i)<=magazine.count(i)):
                continue
            else:
                return False
        return True
                
                
            
        
            