class Solution {
public:
    int divide(int dividend, int divisor) {
        // Handle overflow cases
        if (dividend == std::numeric_limits<int>::min() && divisor == -1)
            return std::numeric_limits<int>::max();
        
        // Handle divisor being 1 or -1
        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return -dividend;

        // Determine sign of the quotient
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        
        // Convert dividend and divisor to positive to simplify calculation
        long long dvd = labs(dividend);
        long long dvs = labs(divisor);
        
        int quotient = 0;
        while (dvd >= dvs) {
            long long temp = dvs, multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            quotient += multiple;
        }
        
        return sign * quotient;
    }
};