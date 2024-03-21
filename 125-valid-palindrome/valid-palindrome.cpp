class Solution {
public:
    bool isPalindrome(std::string s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !isalnum(s[left])) {
                left++;
            }
            // Move right pointer to the next alphanumeric character
            while (left < right && !isalnum(s[right])) {
                right--;
            }
            
            // Convert characters to lowercase and compare
            if (tolower(s[left]) != tolower(s[right])) {
                return false; // Characters are not equal, not a palindrome
            }
            
            // Move pointers inward
            left++;
            right--;
        }
        
        return true; // All characters matched, palindrome
    }
};