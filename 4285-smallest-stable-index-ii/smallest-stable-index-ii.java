class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] traverseLeft=new int[n];
        traverseLeft[0]=nums[0];
        for(int i=1;i<n;i++){
            traverseLeft[i]=Math.max(nums[i],traverseLeft[i-1]);
        }
        int[] traverseRight=new int[n];
        traverseRight[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            traverseRight[i]=Math.min(nums[i],traverseRight[i+1]);
        }
        for(int i=0;i<n;i++){
            if(traverseLeft[i]-traverseRight[i]<=k){
                return i;
            }
        }
        return -1;
    }
} 