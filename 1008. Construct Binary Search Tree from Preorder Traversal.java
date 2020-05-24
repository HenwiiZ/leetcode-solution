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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
    //Remember there could be two situation
    //Consider that if there is no rightChild,
    //The code in if(preorder[i] > preorder[start]) won't be executed
    public TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(preorder[start]);
        int leftEnd = 0;
        int rightStart = 0;
        boolean isRight = false;
        for(int i = start; i <= end; i++) {
            if(preorder[i] > preorder[start]) {
                leftEnd = i - 1;
                rightStart = i;
                isRight = true;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[start]);
        TreeNode leftTree;
        TreeNode rightTree;
        if(!isRight) {
            leftTree = helper(preorder, start + 1, end);
            rightTree = null;
        }
        else {
            leftTree = helper(preorder, start + 1, leftEnd);
            rightTree = helper(preorder, rightStart, end);
        }
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}