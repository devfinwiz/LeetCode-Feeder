class Solution {
public:
    string convertToTitle(int columnNumber) {
        string result = "";
        
        while (columnNumber > 0) {
            // Adjusting to 0-indexed system
            columnNumber--;
            char ch = 'A' + columnNumber % 26;
            result = ch + result;
            columnNumber /= 26;
        }
        
        return result;
    }
};