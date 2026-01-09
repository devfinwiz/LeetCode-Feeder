class Solution {
    Map<TreeNode, Integer> map;
    int max_depth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        map = new HashMap();
        map.put(null, -1);
        dfs(root, null);
        max_depth = -1;
        for (Integer d: map.values())
            max_depth = Math.max(max_depth, d);

        return answer(root);
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            map.put(node, map.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public TreeNode answer(TreeNode node) {
        if (node == null || map.get(node) == max_depth)
            return node;
        TreeNode left = answer(node.left),
                 right = answer(node.right);
        if (left != null && right != null) return node;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}