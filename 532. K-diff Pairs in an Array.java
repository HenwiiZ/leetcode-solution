class Solution {
    public int findPairs(int[] nums, int k) {
        //k < 0没有
        //k = 0只需要判断有重复的数字有几个
        //k < 0在map里查有没有 key+k和key-k的
        if(k < 0) return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        if(k == 0) {
            for(int key: map.keySet()) {
                if(map.get(key) > 1) res++;
            }
            return res;
        }
        else {
            for(int key: map.keySet()) {
                if(map.containsKey(key - k)) res++;
                if(map.containsKey(key + k)) res++;
            }
            return res / 2;
        }
    }
}