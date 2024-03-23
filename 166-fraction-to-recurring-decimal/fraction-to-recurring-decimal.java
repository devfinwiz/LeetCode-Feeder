import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Handle the sign
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Calculate the integer part
        result.append(num / denom);
        long remainder = num % denom;

        // If the remainder is zero, return the integer part only
        if (remainder == 0) {
            return result.toString();
        }

        // Calculate the fractional part
        result.append(".");
        Map<Long, Integer> remainders = new HashMap<>();
        StringBuilder fractionalPart = new StringBuilder();

        while (remainder != 0) {
            if (remainders.containsKey(remainder)) {
                // Found a repeating pattern
                int repeatingIndex = remainders.get(remainder);
                fractionalPart.insert(repeatingIndex, "(");
                fractionalPart.append(")");
                break;
            }

            remainders.put(remainder, fractionalPart.length());
            remainder *= 10;
            fractionalPart.append(remainder / denom);
            remainder %= denom;
        }

        result.append(fractionalPart);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));  // Output: "0.5"
        System.out.println(fractionToDecimal(2, 1));  // Output: "2"
        System.out.println(fractionToDecimal(4, 333));  // Output: "0.(012)"
    }
}
