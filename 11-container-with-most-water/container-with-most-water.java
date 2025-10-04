class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = Integer.MIN_VALUE;
        while(left < right){
            int ht = Math.min(height[left],height[right]);
            int width = right - left;
            area = Math.max(area,ht * width);
            if(height[left] > height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return area;
    }
}