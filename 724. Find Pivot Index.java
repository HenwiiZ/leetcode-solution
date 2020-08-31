class Solution {
    public int pivotIndex(int[] nums) {
        //如果知道了leftSum和nums[pivot]
        //那么右边的sum就是总的和减去上面两个变量
        int leftSum = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum += nums[i];
        for(int i = 0; i < nums.length; i++) {
            if(leftSum == sum - leftSum - nums[i]) return i;
            else leftSum += nums[i];
        }
        return -1;
    }
}