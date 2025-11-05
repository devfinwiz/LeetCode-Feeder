class Solution {
    public String largestPalindromic(String num) {
        TreeMap<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (char ch : num.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        Character middle = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if (count % 2 != 0 && middle == null) {
                middle = ch;
            }
            int pairs = count / 2;
            if (ch == '0' && left.length() == 0)
                continue;
            for (int i = 0; i < pairs; i++) {
                left.append(ch);
                right.append(ch);
            }
        }
        if (left.length() == 0 && middle == null && map.containsKey('0')) {
            return "0";
        }
        right.reverse();
        if (middle != null) {
            left.append(middle);
        }
        left.append(right);

        return left.toString();
    }
}