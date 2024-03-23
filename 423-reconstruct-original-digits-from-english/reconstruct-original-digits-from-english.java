import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String originalDigits(String s) {
        Map<Character, Integer> countMap = new HashMap<>();

        // Count occurrences of each character in the string
        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        // Count occurrences of each digit
        int[] digitCount = new int[10];
        digitCount[0] = countMap.getOrDefault('z', 0);
        digitCount[2] = countMap.getOrDefault('w', 0);
        digitCount[4] = countMap.getOrDefault('u', 0);
        digitCount[6] = countMap.getOrDefault('x', 0);
        digitCount[8] = countMap.getOrDefault('g', 0);

        digitCount[1] = countMap.getOrDefault('o', 0) - digitCount[0] - digitCount[2] - digitCount[4];
        digitCount[3] = countMap.getOrDefault('h', 0) - digitCount[8];
        digitCount[5] = countMap.getOrDefault('f', 0) - digitCount[4];
        digitCount[7] = countMap.getOrDefault('s', 0) - digitCount[6];
        digitCount[9] = countMap.getOrDefault('i', 0) - digitCount[5] - digitCount[6] - digitCount[8];

        // Build the result string based on digit occurrences
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < digitCount[i]; j++) {
                result.append(i);
            }
        }

        return result.toString();
    }

    // Example usage:
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.originalDigits("owoztneoer"));  // Output: "012"
        System.out.println(solution.originalDigits("fviefuro"));     // Output: "45"
    }
}
