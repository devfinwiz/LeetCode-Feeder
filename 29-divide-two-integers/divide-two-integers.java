class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        long quotient = 0;

        while (longDividend >= longDivisor) {
            long temp = longDivisor, multiple = 1;

            while (longDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            longDividend -= temp;
            quotient += multiple;
        }

        return (int) (sign * quotient);
    }
}
