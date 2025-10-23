class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int num1 = (int) s.charAt(i);
                int num2 = (int) s.charAt(i + 1);
                int finalNum = (num1 + num2) % 10;
                sb.append((char) finalNum);
            }
            s = sb.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}