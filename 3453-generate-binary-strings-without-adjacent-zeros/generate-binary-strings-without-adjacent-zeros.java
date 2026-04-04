class Solution {
    public void backtrack(int ind, StringBuilder sb, List<String> lst, int n) {
        if (sb.length() == n) {
            lst.add(sb.toString());
            return;
        }

        if (ind == 0) {
            sb.append('0');
            backtrack(ind + 1, sb, lst, n);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('1');
            backtrack(ind + 1, sb, lst, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        else if (sb.charAt(ind - 1) == '0') {
            sb.append('1');
            backtrack(ind + 1, sb, lst, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        else if (sb.charAt(ind - 1) == '1') {
            sb.append('0');
            backtrack(ind + 1, sb, lst, n);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('1');
            backtrack(ind + 1, sb, lst, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> validStrings(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> lst = new ArrayList<>();
        backtrack(0, sb, lst, n);
        return lst;
    }
}