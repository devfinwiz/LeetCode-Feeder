class Solution {
    int m;
    int n;
    public int[] getBiggestThree(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maximumEdge = (Math.min(m, n)+1)/2;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                for (int edge = 0; edge <= maximumEdge; edge++){
                    int sum = getSum(grid, i, j, edge);
                    if (sum != 0) set.add(sum);
                    if (set.size() > 3) set.pollFirst();
                }
            }
        }
        int[] ans = new int[set.size()];
        int index = set.size()-1;
        for (int i : set){
            ans[index--] = i;
        }
        return ans;
    }
    private int getSum(int[][] grid, int i,int j,int edge){
        if (edge == 0) return grid[i][j];
        if (i+2*edge>=m || j-edge<0 || j+edge>=n) return 0;
        int sum = 0;        
        for (int k = 0; k < edge; k++){
            sum += grid[i+k][j+k]+ grid[i+edge+k][j+edge-k]+ grid[i+2*edge-k][j-k]+ grid[i+edge-k][j-edge+k];            
        }
        return sum;
    }
}