/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return (helper(root) != -1);
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int hLeft = helper(root.left);
        int hRight = helper(root.right);
        if (hLeft == -1 || hRight == -1 || Math.abs(hLeft - hRight) > 1) return -1;
        else return Math.max(hLeft, hRight) + 1;
    }
    
}