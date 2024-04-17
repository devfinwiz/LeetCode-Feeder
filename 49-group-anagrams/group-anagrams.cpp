class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> anagramGroups;
        
        // Group anagrams using a hash table
        for (const string& str : strs) {
            string key = str;
            sort(key.begin(), key.end()); // Sort characters to create a unique identifier
            anagramGroups[key].push_back(str);
        }
        
        // Extract grouped anagrams into the result vector
        vector<vector<string>> result;
        for (auto& group : anagramGroups) {
            result.push_back(group.second);
        }
        
        return result;
    }
};