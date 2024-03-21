class Solution {
public:
    void nextPermutation(std::vector<int>& nums) {
        int n = nums.size();
        
        // Find the first element from the right that is smaller than its next element
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // If such element is found, find the smallest element to the right of nums[i] which is greater than nums[i]
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            std::swap(nums[i], nums[j]);
        }
        
        // Reverse the sub-array to the right of nums[i] to get the next permutation
        std::reverse(nums.begin() + i + 1, nums.end());
    }
};