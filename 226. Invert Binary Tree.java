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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            cur.left = right;
            cur.right = left;
            if(left != null) q.offer(left);
            if(right != null) q.offer(right);
        }
        return root;
    }
}
//recursive
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         invert(root);
//         return root;
//     }
//     public TreeNode invert(TreeNode node) {
//         if(node == null) return null;
//         TreeNode left = invert(node.left);
//         TreeNode right = invert(node.right);
//         node.left = right;
//         node.right = left;
//         return node;
//     }
// }