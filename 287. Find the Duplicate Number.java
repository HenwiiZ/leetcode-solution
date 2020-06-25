class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        fast = 0;
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}

// class Solution {
//     public int findDuplicate(int[] nums) {
//         int left = 0;
//         int right = nums.length - 1;
//         while(left < right - 1) {
//             int mid = (right - left) / 2 + left;
//             int cnt = 0;
//             for(int i = 0; i < nums.length; i++) {
//                 if(nums[i] <= mid) cnt++;
//             }
//             if(cnt > mid) right = mid;
//             else left = mid;
//         }
//         int cnt = 0;
//         for(int i = 0; i < nums.length; i++) {
//             if(nums[i] == left) cnt++;
//             if(cnt > 1) return left;
//         }
//         return right;
//     }
// }