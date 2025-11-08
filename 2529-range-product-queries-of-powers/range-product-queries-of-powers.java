class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int index = 0;
        int sum = n;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) { 
                ans.add(1 << i);
            }
        }
        int ind = 0;
        int[] res = new int[queries.length];
        for(int[] query:queries){
            long MOD = 1_000_000_007;
            long product = 1;
            for (int i = query[0]; i <= query[1]; i++) {
                product = (product * ans.get(i)) % MOD;
            }
            res[ind++] = (int)product;
        }
        return res;
    }
}