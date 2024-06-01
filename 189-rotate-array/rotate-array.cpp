class Solution {
public:
   void rotate(std::vector<int>& nums, int k) {
    int n = nums.size();
    k = k % n; // Handle cases where k is greater than the length of the array
    std::reverse(nums.begin(), nums.end());
    std::reverse(nums.begin(), nums.begin() + k);
    std::reverse(nums.begin() + k, nums.end());
}
};