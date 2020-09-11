class Solution {
    public int maxProduct(int[] nums) {
        //因为数组中存在负数
        //所以当前最大可能是
        //maxP[i - 1] * nums[i] 或 minP[i - 1] * nums[i] 或 nums[i]
        int[] maxP = new int[nums.length];
        int[] minP = new int[nums.length];
        int res = nums[0];
        maxP[0] = nums[0];
        minP[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxP[i] = Math.max(maxP[i - 1] * nums[i], minP[i - 1] * nums[i]);
            maxP[i] = Math.max(maxP[i], nums[i]);
            minP[i] = Math.min(maxP[i - 1] * nums[i], minP[i - 1] * nums[i]);
            minP[i] = Math.min(minP[i], nums[i]);
            res = Math.max(res, maxP[i]);
        }
        return res;
    }
}