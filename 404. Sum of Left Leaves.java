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
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int res = 0;
        boolean isLeft = false;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
                if(cur != null) isLeft = true;
            }
            cur = stack.pop();
            // if(cur != null) System.out.println(cur.val);
            // else System.out.println("null");
            // System.out.println("isLeft");
            // System.out.println(isLeft);
            if(isLeft) {
                isLeft = false;
                if(cur.left == null && cur.right == null) res += cur.val;
            }
            cur = cur.right;
        }
        return res;
    }
}