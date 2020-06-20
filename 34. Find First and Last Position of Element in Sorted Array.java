class Solution {    public int[] searchRange(int[] nums, int target) {        //First, find out the left most index you want        // Then the right most        // What you need to make sure is that when nums[mid] == target        // whether left = mid or right = mid        int[] res = {-1, -1};        int left = 0;        if(nums == null || nums.length == 0) return res;        int right = nums.length - 1;        while(left < right - 1) {            int mid = (right - left) / 2 + left;            if(nums[mid] >= target) right = mid;            else left = mid;        }        if(nums[left] == target) res[0] = left;        else if(nums[right] == target) res[0] = right;        else return res;                left = 0;        right = nums.length - 1;        while(left < right - 1) {            int mid = (right - left) / 2 + left;            if(nums[mid] > target) right = mid;            else left = mid;        }        if(nums[right] == target) res[1] = right;        else if(nums[left] == target) res[1] = left;        return res;    }}