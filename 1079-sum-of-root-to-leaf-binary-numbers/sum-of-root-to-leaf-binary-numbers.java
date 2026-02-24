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
    public void traversal(TreeNode root,StringBuilder sb,ArrayList<String> string){
        if(root==null) return;
        sb.append(root.val);
        if(root.left==null&&root.right==null){
            string.add(sb.toString());
        }
        else{
            traversal(root.left,sb,string);
            traversal(root.right,sb,string);
        }
        sb.deleteCharAt(sb.length()-1);
    }
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        ArrayList<String> string=new ArrayList<>();
        traversal(root,sb,string);
        int sum=0;
        for(int i=0;i<string.size();i++){
            sum+=Integer.parseInt(string.get(i),2);
        }
        return sum;
    }
}