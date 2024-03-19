class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        return mergeSortAndCount(nums, lower, upper);
    }
    
    private int mergeSortAndCount(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        return mergeSort(prefixSum, 0, prefixSum.length - 1, lower, upper);
    }
    
    private int mergeSort(long[] prefixSum, int left, int right, int lower, int upper) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(prefixSum, left, mid, lower, upper) +
                    mergeSort(prefixSum, mid + 1, right, lower, upper);
        int j = mid + 1, k = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && prefixSum[j] - prefixSum[i] < lower) j++;
            while (k <= right && prefixSum[k] - prefixSum[i] <= upper) k++;
            count += k - j;
        }
        merge(prefixSum, left, mid, right);
        return count;
    }
    
    private void merge(long[] prefixSum, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (prefixSum[i] < prefixSum[j]) {
                temp[k++] = prefixSum[i++];
            } else {
                temp[k++] = prefixSum[j++];
            }
        }
        while (i <= mid) temp[k++] = prefixSum[i++];
        while (j <= right) temp[k++] = prefixSum[j++];
        System.arraycopy(temp, 0, prefixSum, left, temp.length);
    }
}
