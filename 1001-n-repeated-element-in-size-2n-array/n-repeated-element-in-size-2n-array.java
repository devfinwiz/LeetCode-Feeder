class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)) return num;
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return nums[0];
    }
}