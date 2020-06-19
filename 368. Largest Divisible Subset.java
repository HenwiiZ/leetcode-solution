class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //dp: len[i] means the length of the longest divisiblie subset from index 0 to index i;
        //maxNum[i] means the last number that nums[i] could be divisible by
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int[] len = new int[nums.length];
        int[] maxNum = new int[nums.length];
        Arrays.sort(nums);
        //Initilize maxNum[] and len[]
        Arrays.fill(len, 1);
        for(int i = 0; i < maxNum.length; i++) {
            maxNum[i] = nums[i];
        }
        
        for(int i = 1; i < len.length; i++) {
            //For each i, since it might be divisible for many numbers before it,
            //for nums[i], we should go through 0 < j < i
            //if(nums[i] % nums[j] && len[i] < len[j] + 1)
            //len[i] = len[j] + 1;
            //Also, we maintain maxNum[i] to be the index of the last number it could be divisible by
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    maxNum[i] = j;
                }
            }
        }        
        int index = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            if(len[i] > maxLen) {
                maxLen = len[i];
                index = i;
            }
        }
        while(maxLen > 0) {
            res.add(0, nums[index]);
            index = maxNum[index];
            maxLen--;
        }
        return res;
    }
}