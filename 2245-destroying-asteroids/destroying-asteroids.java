class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        long currMass = mass;
        for(int i : asteroids){
            if(i <= currMass){
                currMass += i;
                while(!st.isEmpty()){
                    if(currMass >= st.peek()){
                        currMass += st.pop();
                    } else break;
                }
            }
            else{
                if(st.isEmpty() || i < st.peek()) st.push(i);
                else{
                        int temp = st.pop();
                        st.push(i);
                        st.push(temp);
                }
            }
        }
        return st.isEmpty();
    }
}