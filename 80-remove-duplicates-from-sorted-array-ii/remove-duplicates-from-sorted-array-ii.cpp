class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() <= 2) return nums.size(); // No need to process if the size is 2 or less

        int i = 2; // Initialize i to 2, since the first two elements can stay as they are

        for (int j = 2; j < nums.size(); ++j) {
            if (nums[j] > nums[i - 2]) { // Compare current element with the element at position i-2
                nums[i] = nums[j]; // Update the element at position i with the current element
                ++i; // Increment the i pointer
            }
        }
        return i; // The length of the array with duplicates removed
    }
};