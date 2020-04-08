class Solution {
    public boolean canPartition(int[] nums) {
        //能不能分为两子集使得每个子集和为总和一半
        //转化为能不能有一非空子集使得和是总和一半
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum+= nums[i];
        if(sum % 2 != 0) return false;
        sum /= 2;
        //长度为sum+1
        boolean[] dp = new boolean[sum + 1];
        //dp[0]必须为true，不然dp[1]就没有办法变成true
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            for(int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}