class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> result;
        if (digits.empty()) {
            return result;
        }
        vector<string> keypad = {
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        string current;
        generateCombinations(digits, keypad, 0, current, result);
        return result;
    }
    
private:
    void generateCombinations(const string& digits, const vector<string>& keypad, int index, string& current, vector<string>& result) {
        if (index == digits.length()) {
            result.push_back(current);
            return;
        }
        
        int digit = digits[index] - '2';
        for (char c : keypad[digit]) {
            current.push_back(c);
            generateCombinations(digits, keypad, index + 1, current, result);
            current.pop_back();
        }
    }
};