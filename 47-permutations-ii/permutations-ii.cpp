class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> current;
        vector<bool> used(nums.size(), false);
        sort(nums.begin(), nums.end());
        permute(nums, used, current, result);
        return result;
    }

private:
    void permute(vector<int>& nums, vector<bool>& used, vector<int>& current, vector<vector<int>>& result) {
        if (current.size() == nums.size()) {
            result.push_back(current);
            return;
        }
        
        set<int> uniqueValues; // To track already used values in the current position
        for (int i = 0; i < nums.size(); ++i) {
            if (!used[i] && (uniqueValues.find(nums[i]) == uniqueValues.end())) {
                used[i] = true;
                current.push_back(nums[i]);
                permute(nums, used, current, result);
                current.pop_back();
                used[i] = false;
                uniqueValues.insert(nums[i]);
            }
        }
    }
};