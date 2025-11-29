class Solution {
    public int gcd(int num1,int num2){
        while (num2 != 0) {
        int temp = num2;
        num2 = num1 % num2;
        num1 = temp;
        }
        return num1;
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            int curr = num;
            while (!stack.isEmpty()) {
                int top = stack.peek();
                int g = gcd(top, curr);
                if (g == 1) break;
                curr = (top / g) * curr;
                stack.pop();
            }
            stack.push(curr);
        }
        return new ArrayList<>(stack);
    }
}