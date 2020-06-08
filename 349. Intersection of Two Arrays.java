class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            if(!s1.contains(nums1[i]))
                s1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            if(s1.contains(nums2[i]))
                s2.add(nums2[i]);
        }
        int[] res = new int[s2.size()];
        int index = 0;
        Iterator iter = s2.iterator();
        while(iter.hasNext()) {
            res[index++] = (int)iter.next();
        }
        return res;
    }
}