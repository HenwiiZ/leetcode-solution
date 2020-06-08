class Solution {
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }
  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}

// class Solution {
//     public void rotate(int[] nums, int k) {
//         k %= nums.length;
//         int count = 0;
//         for(int i = 0; count < nums.length; i++) {
//             int cur = i;
//             int pre = nums[i];
//             do {
//                 int next = (cur + k) % nums.length;
//                 int temp = nums[next];
//                 nums[next] = pre;
//                 pre = temp;
//                 cur = next;
//                 count++;
//             } while(cur != i);
//         }
//     }
// }


// class Solution {
//     public void rotate(int[] nums, int k) {
//         int[] res = new int[nums.length];
//         k %= nums.length;
//         for(int i = 0; i < k; i++) {
//             res[i] = nums[nums.length - k + i];
//         }
//         for(int i = k; i < nums.length; i++) {
//             res[i] = nums[i - k];
//         }
//         for(int i = 0; i < nums.length; i++) {
//             nums[i] =  res[i];
//         }
//     }
// }