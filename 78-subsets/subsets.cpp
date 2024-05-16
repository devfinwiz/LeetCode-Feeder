class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> current;
        backtrack(nums, 0, current, result);
        return result;
    }
    
private:
    void backtrack(vector<int>& nums, int start, vector<int>& current, vector<vector<int>>& result) {
        result.push_back(current);  // Add the current subset to the result
        for (int i = start; i < nums.size(); ++i) {
            current.push_back(nums[i]);  // Include the current element
            backtrack(nums, i + 1, current, result);  // Recur with the next element
            current.pop_back();  // Exclude the current element (backtrack)
        }
    }
};