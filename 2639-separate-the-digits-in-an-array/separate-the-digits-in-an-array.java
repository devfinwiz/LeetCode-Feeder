class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int num : nums) {
            String s = String.valueOf(num);
            for (char ch : s.toCharArray()) {
                lst.add(ch - '0');
            }
        }
        int[] ans = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            ans[i] = lst.get(i);
        }
        return ans;
    }
}