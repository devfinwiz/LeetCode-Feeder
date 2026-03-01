class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        if(nums.length==1)return new int[]{-1,-1};
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        if(map.size()<2)return new int[]{-1,-1};
        HashMap<Integer,ArrayList<Integer>> map2=new HashMap<>();
        for(int num:nums){
            map2.putIfAbsent(map.get(num),new ArrayList<>());
            map2.get(map.get(num)).add(num);
        }
        int small=nums[0];
        int smallFreq=map.get(small);
        for(int num:nums){
            if(num>small&&map.get(num)!=smallFreq){
                return new int[]{small,num};
            }
        }
        return new int[]{-1,-1};
    }
}