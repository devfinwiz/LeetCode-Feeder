class Solution {
    int[] delRow = {0,-1,0,1};
    int[] delCol = {-1,0,1,0};
    int m = 1_000_000, n = 1_000_000;
    int LIMIT = 20000;
    public boolean dfs(HashSet<String> map, HashSet<String> vis, int[] src, int[] target){
        if(src[0] == target[0] && src[1] == target[1]) return true;
        String key = src[0] + "," + src[1];
        vis.add(key);
        if(vis.size() > LIMIT) return true;
        for(int i = 0; i < 4; i++){
            int newRow = src[0] + delRow[i];
            int newCol = src[1] + delCol[i];
            String newKey = newRow + "," + newCol;
            if((newRow >= 0 && newRow < m) && (newCol >= 0 && newCol < n)
               && !map.contains(newKey) && !vis.contains(newKey)){
                
                if(dfs(map, vis, new int[]{newRow, newCol}, target)) return true;
            }
        }
        return false;
    }
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {   
        HashSet<String> map = new HashSet<>();
        for(int[] block : blocked){
            map.add(block[0] + "," + block[1]);
        }
        return dfs(map, new HashSet<>(), source, target) &&
               dfs(map, new HashSet<>(), target, source);
    }
}