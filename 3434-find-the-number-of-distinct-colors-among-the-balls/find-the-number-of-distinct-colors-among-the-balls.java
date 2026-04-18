class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> bToC = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> cToB = new HashMap<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (bToC.containsKey(ball)) {
                int oldColor = bToC.get(ball);
                ArrayList<Integer> lst = cToB.get(oldColor);
                lst.remove(Integer.valueOf(ball));
                if (lst.size() == 0) {
                    cToB.remove(oldColor);
                }
            }
            bToC.put(ball, color);
            if (!cToB.containsKey(color)) {
                cToB.put(color, new ArrayList<>());
            }
            cToB.get(color).add(ball);
            ans[i] = cToB.size();
        }
        return ans;
    }
}