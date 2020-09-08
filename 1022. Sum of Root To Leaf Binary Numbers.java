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
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        res = 0;
        StringBuilder str = new StringBuilder();
        helper(root, str);
        return res;
    }
    
    public void helper(TreeNode root, StringBuilder s) {
        if(root.left == null && root.right == null) {
            s.append(root.val);
            int sum = 0;
            String path = s.toString();
            for(int i = 0; i < path.length(); i++) {
                sum *= 2;
                sum += path.charAt(i) - '0';
            }
            s.deleteCharAt(s.length() - 1);
            res += sum;
            return;
        }
        s.append(root.val);
        if(root.left != null) helper(root.left, s);
        if(root.right != null) helper(root.right, s);
        s.deleteCharAt(s.length() - 1);
    }
}