import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert integers to strings and define custom sorting comparator
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));

        // Join sorted strings and handle leading zeros
        StringBuilder result = new StringBuilder();
        for (String numStr : numsStr) {
            result.append(numStr);
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage:
        int[] nums1 = {10, 2};
        int[] nums2 = {3, 30, 34, 5, 9};

        Solution solution = new Solution();
        System.out.println(solution.largestNumber(nums1));  // Output: "210"
        System.out.println(solution.largestNumber(nums2));  // Output: "9534330"
    }
}
