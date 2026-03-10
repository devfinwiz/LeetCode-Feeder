class Solution {
    public int func(int[] arr,int val,int add){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>val){
                add-=(arr[i]-val);
            }
        }
        return add;
    }
    public int findBestValue(int[] arr, int target) {
        int maxx=Integer.MIN_VALUE;
        int minn=1;
        int sum=0;
        for(int num:arr){
            maxx=Math.max(maxx,num);
            sum+=num;
        }
        int low=0;
        int high=maxx;
        int minDiff=Integer.MAX_VALUE;
        int minValue=Integer.MIN_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            int updatedSum=func(arr,mid,sum);
            int diff=Math.abs(target-updatedSum);
            if(diff<minDiff||(diff==minDiff&&mid<minValue)){
                minDiff=diff;
                minValue=mid;
            }
            if(updatedSum>target)high=mid-1;
            else{
                low=mid+1;
            }
        }
        return minValue;
    }
}