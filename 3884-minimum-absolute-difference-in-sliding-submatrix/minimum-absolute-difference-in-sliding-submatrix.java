class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] sol=new int[m-k+1][n-k+1];
        for(int i=0;i+k<=m;i++){
            for(int j=0;j+k<=n;j++){
                ArrayList<Integer> lst=new ArrayList<>();
                for(int a=i;a<i+k;a++){
                    for(int b=j;b<j+k;b++){
                        lst.add(grid[a][b]);
                    }
                } 
                int ans=Integer.MAX_VALUE;
                Collections.sort(lst);
                for(int c=1;c<lst.size();c++){
                    if(lst.get(c).equals(lst.get(c-1))){
                        continue;
                    }
                    ans=Math.min(ans,lst.get(c)-lst.get(c-1));
                }
                if(ans!=Integer.MAX_VALUE){
                    sol[i][j]=ans;
                }
            }
        }
        return sol;
    }
}