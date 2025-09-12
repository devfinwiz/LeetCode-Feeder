class Solution {
    public long findScore(int[] nums) {
        int len = nums.length;
        int[][] sort = new int[len][2];
        long ans = 0;
        boolean[] visited = new boolean[len];
        for(int i=0;i<len;i++){
            sort[i][0] = nums[i];
            sort[i][1] = i;
        }
        Arrays.sort(sort,(i,j)->i[0]-j[0]);
        for(int i=0;i<len;i++){
            int num = sort[i][0];
            int index = sort[i][1];
            if(!visited[index]){
                ans+=num;
                if(index - 1 >=0){
                    visited[index-1] = true;
                }
                if(index + 1 < len){
                    visited[index+1] = true;
                }
                visited[index] = true;
            }
        }
        return ans;
    }
}