class Solution {
    public int longestBalanced(int[] nums) {
        int cnt=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            HashMap<Integer,Integer>odd=new HashMap<>();
            HashMap<Integer,Integer>even=new HashMap<>();
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0)even.put(nums[j],even.getOrDefault(nums[j],0)+1);
                else odd.put(nums[j],odd.getOrDefault(nums[j],0)+1);
                if(odd.size()==even.size())cnt=Math.max(cnt,j-i+1);
            }
        }
        if(cnt==Integer.MIN_VALUE)return 0;
        return cnt;
    }
}