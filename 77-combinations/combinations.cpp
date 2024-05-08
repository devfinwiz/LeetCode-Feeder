class Solution {
public:
    std::vector<std::vector<int>> combine(int n, int k) {
        std::vector<std::vector<int>> result;
        std::vector<int> combination;
        backtrack(result, combination, n, k, 1);
        return result;
    }
    
private:
    void backtrack(std::vector<std::vector<int>>& result, std::vector<int>& combination, int n, int k, int start) {
        if (combination.size() == k) {
            result.push_back(combination);
            return;
        }
        
        for (int i = start; i <= n; ++i) {
            combination.push_back(i);
            backtrack(result, combination, n, k, i + 1);
            combination.pop_back();
        }
    }
};