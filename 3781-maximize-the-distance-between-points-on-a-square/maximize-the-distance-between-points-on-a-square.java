class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        List<Long> arr = new ArrayList<>();
        for (int[] p : points) {
            int x = p[0];
            int y = p[1];
            if (x == 0) {
                arr.add((long) y);
            }
            else if(y==side){
                arr.add((long) side + x);
            }
            else if(x==side){
                arr.add(side * 3L - y);
            }
            else{
                arr.add(side * 4L - x);
            }
        }
        Collections.sort(arr);
        long lo = 1;
        long hi = side;
        int ans = 0;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (check(arr, side, k, mid)) {
                lo = mid + 1;
                ans = (int) mid;
            }
            else{
                hi = mid - 1;
            }
        }
        return ans;
    }
    public boolean check(List<Long> arr, int side, int k, long limit) {
        long perimeter = side * 4L;
        for (long start : arr) {
            long end = start + perimeter - limit;
            long cur = start;
            for (int i = 0; i < k - 1; i++) {
                int idx = lowerBound(arr, cur + limit);
                if (idx == arr.size() || arr.get(idx) > end) {
                    cur = -1;
                    break;
                }
                cur = arr.get(idx);
            }
            if (cur >= 0) {
                return true;
            }
        }
        return false;
    }
    public int lowerBound(List<Long> arr, long target) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid)<target){
                left=mid + 1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
}