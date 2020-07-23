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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        int count = 0;
        int l2r = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            count = q.size();
            List<Integer> temp = new LinkedList<Integer>();
            while(count > 0) {
                TreeNode cur = q.poll();
                if(l2r == 1) temp.add(cur.val);
                else temp.add(0, cur.val);
                count--;
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            res.add(temp);
            l2r *= -1;
        }
        return res;
    }
}