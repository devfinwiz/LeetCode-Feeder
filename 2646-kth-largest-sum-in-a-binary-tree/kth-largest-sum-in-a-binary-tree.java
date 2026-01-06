class Pair {
    int level;
    TreeNode node;
    public Pair(TreeNode node, int level) {
        this.level = level;
        this.node = node;
    }
}
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Long> ans = new ArrayList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            if (ans.size() <= level) {
                ans.add((long) node.val);
            } else {
                ans.set(level, ans.get(level) + node.val);
            }

            if (node.left != null) {
                q.add(new Pair(node.left, level + 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, level + 1));
            }
        }

        Collections.sort(ans);
        if (ans.size() < k) return -1;

        return ans.get(ans.size() - k);
    }
}
