class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0;
        int b = 0;
        int aNum = 0;
        int bNum = 0;
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == a) aNum++;
            else if(nums[i] == b) bNum++;
            else if(aNum == 0) {
                a = nums[i];
                aNum++;
            }
            else if(bNum == 0) {
                b = nums[i];
                bNum++;
            }
            else {
                aNum--;
                bNum--;
            }
        }
        
        aNum = 0;
        bNum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == a) aNum++;
            else if(nums[i] == b) bNum++;
        }
        if(aNum > nums.length / 3) res.add(a);
        if(bNum > nums.length / 3) res.add(b);
        return res;
    }
}