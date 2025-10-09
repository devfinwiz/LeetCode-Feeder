class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int low = 0;
        int high = 0;
        int len = arr.length;
        int cnt = 0;
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        if(sum / k >= threshold){
            cnt++;
        }
        for(int i=k;i<len;i++){
            sum+=arr[i];
            sum-=arr[i-k];
            if(sum / k >= threshold){
                cnt++;
            }
        }
        return cnt;
    }
}