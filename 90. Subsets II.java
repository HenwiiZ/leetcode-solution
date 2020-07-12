class Solution {
    private List<List<Integer>> res;
    private List<Integer> sub;
    private boolean[] isUsed;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new LinkedList<>();
        sub = new LinkedList<>();
        isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, 0);
        return res;
    }
    public void helper(int[] nums, int index) {
        if(index >= nums.length) {
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i < sub.size(); i++) temp.add(sub.get(i));
            res.add(temp);
            return;
        }
        if(index > 0 && nums[index - 1] == nums[index] && !isUsed[index - 1]) {
            helper(nums, index + 1);
        }
        else {
            isUsed[index] = true;
            sub.add(nums[index]);
            helper(nums, index + 1);
            sub.remove(sub.size() - 1);
            isUsed[index] = false;
            helper(nums, index + 1);
        }
    }
}