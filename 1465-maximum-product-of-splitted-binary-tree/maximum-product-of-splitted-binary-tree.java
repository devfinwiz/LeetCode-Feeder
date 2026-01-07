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
    long ans=0;
    long MOD=1000000007L;
    public long dfs(TreeNode node){
        if(node == null) return 0;
        node.val+=dfs(node.left)+dfs(node.right);
        return node.val;
    }
    public int maxProduct(TreeNode root) {
        long sum=dfs(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null)continue;
            long curr=(sum-node.val)*node.val;
            ans=Math.max(ans,curr);
            if(node.left!=null)q.offer(node.left);
            if(node.right!=null)q.offer(node.right);
        }
        return (int)(ans%MOD);
    }
}