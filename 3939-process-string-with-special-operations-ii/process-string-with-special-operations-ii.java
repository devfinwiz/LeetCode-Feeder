class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n + 1];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            long length = lengths[i];
            if (Character.isLowerCase(ch)) {
                lengths[i + 1] = length + 1;
            }
            else if (ch == '*') {
                lengths[i + 1] = Math.max(0, length - 1);
            }
            else if (ch == '#') {
                lengths[i + 1] = length * 2;
            }
            else if (ch == '%') {
                lengths[i + 1] = length;
            }
        }
        long finalLength = lengths[n];
        if (k < 0 || k >= finalLength) {
            return '.';
        }
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long beforeLen = lengths[i];
            long afterLen = lengths[i + 1];
            if (Character.isLowerCase(ch)) {
                if (k == afterLen - 1) {
                    return ch;
                }
            }
            else if (ch == '*') {
               continue;
            }
            else if (ch == '#') {
                if (k >= beforeLen) {
                    k -= beforeLen;
                }
            }
            else if (ch == '%') {
                k = beforeLen - 1 - k;
            }
        }
        return '.';       
    }
}