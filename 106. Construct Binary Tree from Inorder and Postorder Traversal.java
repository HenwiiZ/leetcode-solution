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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || inorder.length != postorder.length)
            return null;
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int post_start, int in_start, int in_end) {
        if(post_start < 0 || in_start > in_end) return null;
        int i = 0;
        TreeNode root = new TreeNode(postorder[post_start]);
        while(i <= in_end) {
            if (inorder[i] == postorder[post_start])
                break;
            i++;
        }
        root.left = helper(inorder, postorder, post_start - (in_end - i + 1), in_start, i - 1);
        root.right = helper(inorder, postorder, post_start - 1, i + 1, in_end);
        return root;
    }
}