class Solution {
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;

        // Step 1: Skip leading whitespaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Check for '+' or '-'
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Step 3: Read in digits until a non-digit character is encountered
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Step 4: Check for integer overflow
            if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
}
