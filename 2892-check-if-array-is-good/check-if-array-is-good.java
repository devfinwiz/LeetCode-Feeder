class Solution {
    public boolean isGood(int[] nums) {
        int maxx=Integer.MIN_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            maxx=Math.max(num,maxx);
            map.put(num,map.getOrDefault(num,0)+1);
        }
        if(maxx+1!=nums.length)return false;
        for (int i = 1; i < maxx; i++) {
            if (map.getOrDefault(i, 0) != 1) {
                return false;
            }
        }
        return map.getOrDefault(maxx, 0) == 2;
    }
}