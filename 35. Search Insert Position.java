class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right - 1) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid;
            else left = mid;
        }
        if(nums[right] < target) return right + 1;
        else if(nums[left] >= target) return left;
        else return right;
    }
}