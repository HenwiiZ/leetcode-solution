class Solution {
    //Put all the non-zero value in the front index
    //Then set remaining elements zero
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int j = index; j < len; j++) {
            nums[j] = 0;
        }
    }
}



class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(slow < nums.length) {
            if(nums[slow] == 0) {
                fast = slow + 1;
                while(fast <nums.length && nums[fast] == 0) {
                    fast++;
                }
                if(fast >= nums.length) return;
                int temp = nums[fast];
                nums[slow] = temp;
                nums[fast] = 0;
            }           
            slow++;
        }
    }
}