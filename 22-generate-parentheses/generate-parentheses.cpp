class Solution {
public:
    std::vector<std::string> generateParenthesis(int n) {
        std::vector<std::string> result;
        generateParenthesisHelper(n, 0, 0, "", result);
        return result;
    }

private:
    void generateParenthesisHelper(int n, int open, int close, std::string current, std::vector<std::string>& result) {
        if (current.length() == 2 * n) {
            result.push_back(current);
            return;
        }

        if (open < n) {
            generateParenthesisHelper(n, open + 1, close, current + '(', result);
        }

        if (close < open) {
            generateParenthesisHelper(n, open, close + 1, current + ')', result);
        }
    }
};