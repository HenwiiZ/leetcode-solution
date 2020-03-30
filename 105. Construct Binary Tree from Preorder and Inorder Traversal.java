/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursive就完事了
//对于preorder，第一个元素必是root，然后找到inorder中root的位置
//root左边的都是左子树，右边的都是右子树
//对于preorder，root右边第一个一定是左子树的root，知道左子树的size后也可以找到右子树的root
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0)
            return null;
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int pre_start, int in_start, int in_end) {
        if (pre_start > preorder.length || in_start > in_end) return null;
        TreeNode root = new TreeNode(preorder[pre_start]);
        int index = 0;
        for (int i = 0; i <= in_end; i++) {
            if (inorder[i] == preorder[pre_start]) {              
                index = i;
                break;
            }
        }
        root.left = helper(preorder, inorder, pre_start + 1, in_start, index - 1);
        root.right = helper(preorder, inorder, pre_start + (index - in_start + 1), index + 1, in_end);
        return root;
    }
}