class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int minn=Integer.MAX_VALUE;
        int maxx=Integer.MIN_VALUE;
        for(int num:nums){
            minn=Math.min(minn,num);
            maxx=Math.max(maxx,num);
        }
        return (long)Math.abs(maxx-minn)*k;

    }
}