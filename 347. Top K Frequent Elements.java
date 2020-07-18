class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = -1;
        }
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                int temp = map.get(nums[i]) + 1;
                map.put(nums[i], temp);
            }
            if(index >= k) {
                int last = map.get(res[k - 1]);
                if(last < temp) {
                    res[k - 1] = nums[i];
                }
            }
            else {
                res[index] = nums[i];
                index++;
            }            
            
        }
        return res;
    }
}