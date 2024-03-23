import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, result, current, used);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;

                backtrack(nums, result, current, used);

                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}
