class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        HashSet<Integer>[][] visited=new HashSet[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=new HashSet<>();
            }
        }
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{0,0,grid[0][0]});
        visited[0][0].add(grid[0][0]);
        int minn=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] node=q.poll();
            int i=node[0];
            int j=node[1];
            int val=node[2];
            if(i==m-1&&j==n-1){
                minn=Math.min(minn,val);
                continue;
            }
            if(j+1<n){
                int next=val^grid[i][j+1];
                if(!visited[i][j+1].contains(next)){
                    visited[i][j+1].add(next);
                    q.offer(new int[]{i,j+1,next});
                }
            }
            if(i+1<m){
                int next=val^grid[i+1][j];
                if(!visited[i+1][j].contains(next)){
                    visited[i+1][j].add(next);
                    q.offer(new int[]{i+1,j,next});
                }
            }
        }
        return minn;
    }
}