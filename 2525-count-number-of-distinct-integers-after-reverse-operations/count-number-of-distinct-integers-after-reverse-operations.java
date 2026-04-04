class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
            int rev=0;
            int temp=num;
            while(temp>0){
                rev=rev*10+(temp%10);
                temp/=10;
            }
            set.add(rev);
        }
        return set.size();
    }
}