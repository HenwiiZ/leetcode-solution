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
    //终止条件：null就return，左右孩子都是null就判断能不能加进去
    private List<List<Integer>> res;
    private List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        if(root == null) return res;
        helper(root, 0, sum);
        return res;
    }
    public void helper(TreeNode cur, int sum, int target) {
        if(cur == null) return;
        if(cur.left == null && cur.right == null) {
            if(sum + cur.val == target) {
                path.add(cur.val);
                List<Integer> temp = new LinkedList<>();
                for(int i = 0; i < path.size(); i++) {
                    temp.add(path.get(i));
                }
                path.remove(path.size() - 1);
                res.add(temp);
            }
            return;
        }
        path.add(cur.val);
        helper(cur.left, sum + cur.val, target);
        helper(cur.right, sum + cur.val, target);
        path.remove(path.size() - 1);
    }
}