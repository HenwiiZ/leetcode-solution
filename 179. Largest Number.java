class Solution {
    public String largestNumber(int[] nums) {
        //Construct a Comparator
        //String could be easy to compare with other string
        //For example, it is hard to compare 3, 30, 34
        //but if you concatenate them like 34303 and 34330, you could know that which is bigger
        if(nums.length == 0) return "";
        Integer[] numsTemp = new Integer[nums.length];
        boolean allZeros = true;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) allZeros = false;
            Integer temp = new Integer(nums[i]);
            numsTemp[i] = temp;
        }
        Arrays.sort(numsTemp, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                StringBuilder s1 = new StringBuilder();
                String str1 = s1.append(num1).append(num2).toString();
                // System.out.println(str1);
                s1.delete(0, s1.length());
                String str2 = s1.append(num2).append(num1).toString();
                // System.out.println(str2);
                return str2.compareTo(str1);
            }
        });
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < numsTemp.length; i++) {
            s.append(numsTemp[i]);
        }
        return allZeros? "0": s.toString();
    }
}