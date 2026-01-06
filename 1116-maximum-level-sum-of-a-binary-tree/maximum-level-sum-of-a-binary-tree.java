/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int currSum = 0;
            for(int i = 1;i<=size;i++){
                TreeNode node = queue.poll();
                currSum= currSum + node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                currSum+=node.val;
            }   
            if(currSum > maxSum){
                maxSum = currSum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}