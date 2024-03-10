import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (!seen[currentChar - 'a']) {
                while (!stack.isEmpty() && currentChar < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                    seen[stack.pop() - 'a'] = false;
                }
                seen[currentChar - 'a'] = true;
                stack.push(currentChar);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc")); // Output: "abc"
        System.out.println(solution.removeDuplicateLetters("cbacdcbc")); // Output: "acdb"
    }
}
