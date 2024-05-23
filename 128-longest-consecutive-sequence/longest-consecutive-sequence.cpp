class Solution {
public:
    int longestConsecutive(std::vector<int>& nums) {
        if (nums.empty()) return 0;

        std::unordered_set<int> num_set(nums.begin(), nums.end());
        int longest_streak = 0;

        for (const int& num : num_set) {
            if (!num_set.count(num - 1)) {
                int current_num = num;
                int current_streak = 1;

                while (num_set.count(current_num + 1)) {
                    current_num += 1;
                    current_streak += 1;
                }

                longest_streak = std::max(longest_streak, current_streak);
            }
        }

        return longest_streak;
    }
};