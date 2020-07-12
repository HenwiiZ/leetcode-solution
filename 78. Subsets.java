class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        helper(nums, 0, res, comb);
        return res;
    }
    // public static void helper(int[] nums, int index, List<List<Integer>> res, List<Integer> comb) {
    //     res.add(new ArrayList<Integer>(comb));
    //     for(int i = index; i < nums.length; i++) {
    //         comb.add(nums[i]);
    //         helper(nums, i + 1, res, comb);
    //         comb.remove(comb.size() - 1);           
    //     }
    // }
    public static void helper(int[] nums, int index, List<List<Integer>> res, List<Integer> comb) {
        if(index == nums.length) res.add(new ArrayList<Integer>(comb));
        else {
            comb.add(nums[index]);
            helper(nums, index + 1, res, comb);
            comb.remove(comb.size() - 1);
            helper(nums, index + 1, res, comb);
        }
    }
}