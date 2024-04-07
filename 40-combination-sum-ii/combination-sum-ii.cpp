class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> combination;
        sort(candidates.begin(), candidates.end());
        backtrack(result, combination, candidates, target, 0);
        return result;
    }
    
private:
    void backtrack(vector<vector<int>>& result, vector<int>& combination, vector<int>& candidates, int target, int start) {
        if (target == 0) {
            result.push_back(combination);
            return;
        }
        
        for (int i = start; i < candidates.size() && candidates[i] <= target; ++i) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) 
                continue;
            
            combination.push_back(candidates[i]);
            backtrack(result, combination, candidates, target - candidates[i], i + 1);
            combination.pop_back();
        }
    }
};