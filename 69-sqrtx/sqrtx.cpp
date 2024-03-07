class Solution {
public:
    int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long left = 0;
        long right = x;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                left = mid + 1;
                result = mid;  // Update result when mid^2 is less than x
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
};