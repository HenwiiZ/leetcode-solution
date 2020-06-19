class Solution {
    public int findMin(int[] nums) {
        // if(nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        if(left == right || nums[left] < nums[right]) return nums[left];
        while(left < right - 1) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] < nums[0])
                right = mid;
            else
                left = mid;
        }
        if(nums[left] > nums[right]) return nums[right];
        else return nums[left];
    }
}