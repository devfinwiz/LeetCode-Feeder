class Solution {
public:
    int myAtoi(std::string s) {
        int i = 0;
        int sign = 1;
        long result = 0;

        // Step 1: Ignore leading whitespace
        while (i < s.size() && s[i] == ' ') {
            i++;
        }

        // Step 2: Check for sign
        if (i < s.size() && (s[i] == '-' || s[i] == '+')) {
            sign = (s[i++] == '-') ? -1 : 1;
        }

        // Step 3: Read digits until a non-digit character is encountered
        while (i < s.size() && isdigit(s[i])) {
            result = result * 10 + (s[i++] - '0');

            // Step 4: Check if result is within the 32-bit signed integer range
            if (result * sign > INT_MAX) {
                return INT_MAX;
            } else if (result * sign < INT_MIN) {
                return INT_MIN;
            }
        }

        return result * sign;
    }
};