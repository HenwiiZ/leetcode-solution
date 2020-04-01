class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            int len = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    len = Math.max(len, dp[j]);
                }
            }
            dp[i] = len + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}