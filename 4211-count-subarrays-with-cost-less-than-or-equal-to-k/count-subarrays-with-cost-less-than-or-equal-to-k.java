class Solution {
    public long countSubarrays(int[] nums, long k) {
        Deque<Integer> dq1=new ArrayDeque<>();
        Deque<Integer> dq2=new ArrayDeque<>();
        long cnt=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            while(!dq2.isEmpty()&&nums[dq2.peekLast()]<=nums[right]){
                dq2.pollLast();
            }
            dq2.addLast(right);
            while(!dq1.isEmpty()&&nums[dq1.peekLast()]>=nums[right]){
                dq1.pollLast();
            }
            dq1.addLast(right);
            while(((long)nums[dq2.peekFirst()]-(long)nums[dq1.peekFirst()])*(right-left+1)>k){
                if(dq1.peekFirst()==left)dq1.pollFirst();
                if(dq2.peekFirst()==left)dq2.pollFirst();
                left++;
            }
            cnt+=(right-left+1);
        }
        return cnt;
    }
}