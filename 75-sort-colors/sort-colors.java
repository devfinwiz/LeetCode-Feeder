class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length - 1;
        
        while (white <= blue) {
            if (nums[white] == 0) {
                swap(nums, red++, white++);
            } else if (nums[white] == 1) {
                white++;
            } else {
                swap(nums, white, blue--);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
