class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>m=new HashMap<>();
        int b[]=new int[2];
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target-nums[i])){
                b[0]=m.get(target-nums[i]);
                b[1]=i;
            }
            m.put(nums[i],i);
        }
        return b;
    }
}