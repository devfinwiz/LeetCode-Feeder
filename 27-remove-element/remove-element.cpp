class Solution {
public:
    int removeElement(std::vector<int>& nums, int val) {
        int k = 0; // Represents the count of elements not equal to val

        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
};