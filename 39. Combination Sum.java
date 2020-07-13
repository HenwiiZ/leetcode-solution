class Solution {
    private List<List<Integer>> res;
    private List<Integer> comb;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        comb = new LinkedList<>();
        helper(candidates, 0, target, 0);
        return res;
    }
    public void helper(int[] candidates, int sum, int target, int curIndex) {
        if(sum > target) return;
        else if(sum == target) {
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i < comb.size(); i++) temp.add(comb.get(i));
            res.add(temp);
        }
        else {
            for(int i = curIndex; i < candidates.length; i++) {
                comb.add(candidates[i]);
                helper(candidates, sum + candidates[i], target, i);
                comb.remove(comb.size() - 1);
            }
        }
    }
}