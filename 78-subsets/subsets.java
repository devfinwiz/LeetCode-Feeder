import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset)); // Add the current subset to the result
        
        // Generate subsets by including each element one by one
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]); // Include the current element
            backtrack(nums, i + 1, subset, result); // Recursively generate subsets
            subset.remove(subset.size() - 1); // Backtrack: remove the last element to backtrack
        }
    }
}
