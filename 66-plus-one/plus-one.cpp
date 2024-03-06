class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size();

        // Start from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit
            digits[i]++;
            
            // If the digit becomes 10, set it to 0 and carry 1
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                // If no carry, we are done
                return digits;
            }
        }

        // If we reach here, all digits were 9, and we have a carry
        digits.insert(digits.begin(), 1);

        return digits;
    }
};
