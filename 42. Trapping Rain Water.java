class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int leftMost = 0;
        int rightMost = 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left <= right) {
            leftMost = leftMost < height[left]? height[left] : leftMost;
            rightMost = rightMost < height[right]? height[right] : rightMost;
            if(leftMost < rightMost) {
                res += leftMost - height[left];
                left++;
            }
            else {
                res+= rightMost - height[right];
                right--;
            }
        }
        return res;
    }
}

// class Solution {
//     public int trap(int[] height) {
//         if(height == null || height.length < 3) return 0;
//         int[] left = new int[height.length];
//         int[] right = new int[height.length];
//         left[0] = height[0];
//         right[height.length - 1] = height[height.length - 1];
//         for(int i = 1; i < height.length; i++) {
//             left[i] = Math.max(height[i], left[i - 1]);
//         }
//         for(int i = height.length - 2; i >= 0; i--) {
//             right[i] = Math.max(height[i], right[i + 1]);
//         }
//         int res = 0;
//         for(int i = 0; i < height.length; i++) {
//             int temp = Math.min(right[i], left[i]);
//             if(temp > height[i]) res += temp - height[i];
//         }
//         return res;
//     }
// }