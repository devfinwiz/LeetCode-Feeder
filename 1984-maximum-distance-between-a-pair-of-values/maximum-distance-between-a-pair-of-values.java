class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int len=nums2.length;
        int maxxDiff=Integer.MIN_VALUE;
        for(int i=0;i<nums1.length;i++){
            int low=i;
            int high=len-1;
            int maxxIndex=0;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums2[mid]>=nums1[i]){
                    maxxIndex=mid;
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            maxxDiff=Math.max(maxxIndex-i,maxxDiff);
        }
        return maxxDiff;
    }
}