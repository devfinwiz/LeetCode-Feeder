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
    public void inOrder(TreeNode root,List<Integer> inorder){
        if(root == null) return ;
        inOrder(root.left,inorder);
        inorder.add(root.val);
        inOrder(root.right,inorder);
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inOrder(root,inorder);
        for(int i = 0;i<inorder.size()-1;i++){
            if(inorder.get(i) >= inorder.get(i+1)) return false;
        }

        return true;

        
    }
}