class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st=new Stack<>();
        for(int num:nums){
            long curr=num;
            while(!st.isEmpty()&&st.peek().equals(curr)){
                curr+=st.pop();
            }
            st.push(curr);
        }
        return new ArrayList<>(st);
    }
}