class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : freqMap.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }
        for (int num : nums) {
            int freq = freqMap.get(num);
            if (freqCount.get(freq) == 1) {
                return num;
            }
        }
        return -1;
    }
}