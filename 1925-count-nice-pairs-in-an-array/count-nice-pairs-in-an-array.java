class Solution {
    public int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num = num / 10;
        }
        return rev;
    }
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;
        for (int num : nums) {
            int key = num - reverse(num);
            int freq = map.getOrDefault(key, 0);
            count = (count + freq) % MOD;
            map.put(key, freq + 1);
        }
        return (int) count;
    }
}
