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
    private int res;
    public int pathSum(TreeNode root, int sum) {
        res = 0;
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            isPath(n, sum);
            if(n.left != null)
                q.offer(n.left);
            if(n.right != null)
                q.offer(n.right);
        }
        return res;
    }
    //递归会超时
    // public void helper(TreeNode cur, int sum) {
    //     if(cur == null) return;
    //     isPath(cur, sum);
    //     helper(cur.left, sum);
    //     helper(cur.right, sum);
    // }
    public void isPath(TreeNode root, int sum) {
        if(root == null) return;
        if(sum - root.val == 0) {
            res++;
            // return;
        }
        isPath(root.left, sum - root.val);
        isPath(root.right, sum - root.val);
    }
}