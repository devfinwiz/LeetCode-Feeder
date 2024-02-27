class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) {
            return ""; // Return empty string if the input array is empty
        }

        // Iterate through characters of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            // Check if the current character is common among all strings
            for (int j = 1; j < strs.size(); j++) {
                if (i >= strs[j].length() || strs[j][i] != strs[0][i]) {
                    return strs[0].substr(0, i); // Return common prefix found so far
                }
            }
        }

        return strs[0]; // If loop completes, the entire first string is the common prefix
    }
};