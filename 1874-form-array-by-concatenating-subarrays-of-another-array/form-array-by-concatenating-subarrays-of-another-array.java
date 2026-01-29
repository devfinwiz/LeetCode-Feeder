class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i=0;
        for(int j=0;j<groups.length;j++) {
            int[] group=groups[j];
            boolean found=false;
            while(i+group.length<=nums.length) {
                int k=0;
                while(k<group.length&&nums[i+k]==group[k]) {
                    k++;
                }
                if(k==group.length){
                    i+=group.length;
                    found=true;
                    break;
                }
                i++;
            }
            if(!found)return false;
        }
        return true;
    }
}
