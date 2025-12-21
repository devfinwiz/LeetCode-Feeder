class Solution {
    public int minDeletionSize(String[] strs) {
        HashMap<Integer, String> map = new HashMap<>();
        int len = strs[0].length();
        int rows = strs.length;
        StringBuilder sb = new StringBuilder();
        boolean[] fixed = new boolean[rows - 1];
        int count = 0;
        for (int i = 0; i < len; i++) {
            sb.setLength(0);
            for (int j = 0; j < rows; j++) {
                sb.append(strs[j].charAt(i));
            }
            map.put(i, sb.toString());
        }
        for (int i = 0; i < len; i++) {
            String col = map.get(i);
            boolean delete = false;
            for (int r = 0; r < rows - 1; r++) {
                if (!fixed[r] && col.charAt(r) > col.charAt(r + 1)) {
                    delete = true;
                    break;
                }
            }
            if (delete) {
                count++;
            } 
            else {
                for (int r = 0; r < rows - 1; r++) {
                    if (!fixed[r] && col.charAt(r) < col.charAt(r + 1)) {
                        fixed[r] = true;
                    }
                }
            }
        }

        return count;
    }
}
