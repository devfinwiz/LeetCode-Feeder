class Solution {
public:
    int maxProduct(std::vector<int>& nums) {
        if (nums.empty()) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (size_t i = 1; i < nums.size(); ++i) {
            if (nums[i] < 0) {
                std::swap(maxProduct, minProduct);
            }
            maxProduct = std::max(nums[i], maxProduct * nums[i]);
            minProduct = std::min(nums[i], minProduct * nums[i]);

            result = std::max(result, maxProduct);
        }

        return result;
    }
};
