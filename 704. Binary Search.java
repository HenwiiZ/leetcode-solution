class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid;
            else right = mid;
        }
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
}