class Solution {
public:
    void sortColors(std::vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        int mid = 0;
        
        while (mid <= high) {
            switch(nums[mid]) {
                case 0:
                    std::swap(nums[low++], nums[mid++]);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    std::swap(nums[mid], nums[high--]);
                    break;
            }
        }
    }
};