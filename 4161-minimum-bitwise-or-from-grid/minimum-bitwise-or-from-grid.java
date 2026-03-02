class Solution {
    int totalMinn=Integer.MAX_VALUE;
    public int memo(int row,int curr,HashMap<Integer,Integer>[]map,int[][] ans,int m,int n){
        if(curr>=totalMinn)return Integer.MAX_VALUE;
        if(row==m){
            totalMinn=Math.min(totalMinn,curr);
            return curr;
        }
        if(map[row].containsKey(curr))return map[row].get(curr);
        int minn=Integer.MAX_VALUE;
        for(int num:ans[row]){
            int next=curr|num;
            if(next>=totalMinn)continue;
            minn=Math.min(minn,memo(row+1,next,map,ans,m,n));
        }
        map[row].put(curr,minn);
        return minn;
    }
    public int minimumOR(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        HashMap<Integer,Integer>[] map=new HashMap[m];
        int[][] ans=grid;
        for(int i=0;i<m;i++){
            map[i]=new HashMap<>();
        }
        return memo(0,0,map,ans,m,n);
    }
}