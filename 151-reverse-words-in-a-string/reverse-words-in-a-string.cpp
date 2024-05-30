class Solution {
public:
    std::string reverseWords(std::string s) {
        // Trim leading and trailing spaces
        size_t start = s.find_first_not_of(" ");
        size_t end = s.find_last_not_of(" ");
        if (start == std::string::npos || end == std::string::npos) {
            return ""; // the string contains only spaces
        }
        s = s.substr(start, end - start + 1);

        // Split the string by spaces into words
        std::stringstream ss(s);
        std::string word;
        std::vector<std::string> words;
        while (ss >> word) {
            words.push_back(word);
        }

        // Reverse the order of words
        std::reverse(words.begin(), words.end());

        // Join the words with a single space
        std::string result;
        for (size_t i = 0; i < words.size(); ++i) {
            result += words[i];
            if (i != words.size() - 1) {
                result += " ";
            }
        }

        return result;
    }
};

// Example usage