class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (int q : queries) {
            int num = nums[q];
            List<Integer> list = map.get(num);
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }
            int idx=Collections.binarySearch(list,q);
            int prev=list.get((idx-1+list.size())%list.size());
            int next=list.get((idx+1)%list.size());
            int dist1=Math.abs(q-prev);
            int dist2=Math.abs(next-q);
            dist1=Math.min(dist1,n-dist1);
            dist2=Math.min(dist2,n-dist2);
            ans.add(Math.min(dist1,dist2));
        }
        return ans;
    }
}
