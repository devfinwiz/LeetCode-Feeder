class Solution {
public:
    int maximumGap(vector<int>& nums) {
        int n = nums.size();
    if (n < 2) return 0;

    int minVal = *min_element(nums.begin(), nums.end());
    int maxVal = *max_element(nums.begin(), nums.end());

    if (minVal == maxVal) return 0;

    int bucketSize = max(1, (maxVal - minVal) / (n - 1));
    int bucketCount = (maxVal - minVal) / bucketSize + 1;

    vector<int> bucketMin(bucketCount, INT_MAX);
    vector<int> bucketMax(bucketCount, INT_MIN);

    for (int num : nums) {
        int bucketIndex = (num - minVal) / bucketSize;
        bucketMin[bucketIndex] = min(bucketMin[bucketIndex], num);
        bucketMax[bucketIndex] = max(bucketMax[bucketIndex], num);
    }

    int maxGap = 0;
    int prevMax = minVal;

    for (int i = 0; i < bucketCount; ++i) {
        if (bucketMin[i] == INT_MAX) continue;  // Empty bucket
        maxGap = max(maxGap, bucketMin[i] - prevMax);
        prevMax = bucketMax[i];
    }

    return maxGap;
    }
};