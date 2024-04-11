class Solution {
public:
    int titleToNumber(std::string columnTitle) {
        int result = 0;
        
        for (char c : columnTitle) {
            result *= 26; // Multiply the result by 26 for each character
            
            // Subtract 'A' to convert the character to its corresponding value (e.g., 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26)
            result += c - 'A' + 1;
        }
        
        return result;
    }
};