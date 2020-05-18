class Solution {
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        String str = "";
        List<String> res = new LinkedList<String>();
        helper(res, str, left, right);
        return res;
    }
    public void helper(List<String> res, String str, int left, int right) {
        if(right == 0) {
            res.add(str.toString());
            return;
        }
        if(left > 0) {
            helper(res, str + ("("), left - 1, right);
        }
        if(right > left) {
            helper(res, str + (")"), left, right - 1);
        }
    }
}