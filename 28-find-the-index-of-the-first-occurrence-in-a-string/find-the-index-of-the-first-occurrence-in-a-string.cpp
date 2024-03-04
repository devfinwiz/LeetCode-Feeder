class Solution {
public:
    int strStr(std::string haystack, std::string needle) {
        int hay_len = haystack.length();
        int needle_len = needle.length();

        if (needle_len == 0) {
            return 0; // Empty needle, needle found at index 0
        }

        for (int i = 0; i <= hay_len - needle_len; ++i) {
            if (haystack.substr(i, needle_len) == needle) {
                return i; // Found needle, return the index
            }
        }

        return -1; // Needle not found
    }
};