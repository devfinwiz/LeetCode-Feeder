class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxWater = 0;
        int left = 0;
        int right = height.size() - 1;

        while (left < right) {
            // Calculate the width and height of the container
            int width = right - left;
            int h = min(height[left], height[right]);

            // Update the maximum water if the current container can hold more
            maxWater = max(maxWater, width * h);

            // Move the pointers towards the center
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
};