class Solution {
public:
    bool isIsomorphic(std::string s, std::string t) {
        if (s.length() != t.length()) return false;

        std::unordered_map<char, char> mapping_s_to_t;
        std::unordered_set<char> mapped_characters;

        for (int i = 0; i < s.length(); ++i) {
            char s_char = s[i];
            char t_char = t[i];

            if (mapping_s_to_t.find(s_char) != mapping_s_to_t.end()) {
                // If the mapping already exists, check if it matches the current character in t
                if (mapping_s_to_t[s_char] != t_char) {
                    return false;
                }
            } else {
                // If the mapping does not exist, create a new one
                if (mapped_characters.find(t_char) != mapped_characters.end()) {
                    // If t_char is already mapped to some other character, return false
                    return false;
                }
                mapping_s_to_t[s_char] = t_char;
                mapped_characters.insert(t_char);
            }
        }

        return true;
    }
};