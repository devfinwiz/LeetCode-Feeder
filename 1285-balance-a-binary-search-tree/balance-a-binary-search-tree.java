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
    public TreeNode constr(ArrayList<Integer> array,int low,int high){
        if(low>high)return null;
        int mid=low+(high-low)/2;
        TreeNode left=constr(array,low,mid-1);
        TreeNode right=constr(array,mid+1,high);
        TreeNode node=new TreeNode(array.get(mid),left,right);
        return node;
    }
    public void inorder(TreeNode root,ArrayList<Integer> array){
        if(root==null)return;
        inorder(root.left,array);
        array.add(root.val);
        inorder(root.right,array);
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> array=new ArrayList<>();
        inorder(root,array);
        return constr(array,0,array.size()-1);
    }
}