/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//help返回的是经过这个点的左子树路或右子树路
//真正的最大值由全局变量维护
class Solution {
    private int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    public int helper(TreeNode cur) {
        if(cur == null) return 0;
        int left = Math.max(helper(cur.left), 0);
        int right = Math.max(helper(cur.right), 0);
        res = Math.max(res, left + cur.val + right);
        return cur.val + Math.max(0, Math.max(left, right));
    }
}