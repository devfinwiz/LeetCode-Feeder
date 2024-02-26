class Solution {
public:
    int lengthOfLongestSubstring(std::string s) {
        int n = s.length();
        int maxLength = 0;
        int pre = 0, post = 0;
        std::unordered_set<char> charSet;

        while (post < n) {
            if (charSet.find(s[post]) == charSet.end()) {
                charSet.insert(s[post]);
                maxLength = std::max(maxLength, post - pre + 1);
                post++;
            } else {
                charSet.erase(s[pre]);
                pre++;
            }
        }

        return maxLength;
    }
};
