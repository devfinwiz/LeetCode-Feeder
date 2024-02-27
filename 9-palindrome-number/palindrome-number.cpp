class Solution {
public:
    bool isPalindrome(int x) {
        // Convert integer to string
        std::string str = std::to_string(x);

        // Check if the string is a palindrome
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str[left] != str[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
};
