class Solution {
    public int[] findXSum(int[] nums, int windowSize, int topX) {
        int n = nums.length;
        int[] result = new int[n - windowSize + 1];
        for (int start = 0; start <= n - windowSize; ++start) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int end = start; end < start + windowSize; ++end) {
                map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            }
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                list.add(new int[]{entry.getValue(), entry.getKey()});
            }
            list.sort((a, b) -> 
                b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]
            );
            int sum = 0;
            for (int i = 0; i < topX && i < list.size(); ++i) {
                sum += list.get(i)[0] * list.get(i)[1];
            }
            result[start] = sum;
        }
        return result;
    }
}
