class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < nums1.length; i++) {
            if(m1.containsKey(nums1[i])) {
                m1.put(nums1[i], m1.get(nums1[i]) + 1);
            }
            else {
                m1.put(nums1[i], 1);
            }
        }
        for(int i = 0; i < nums2.length; i++) {
            if(m1.containsKey(nums2[i])) {
                if(m1.get(nums2[i]) > 0) {
                    m1.put(nums2[i], m1.get(nums2[i]) - 1);
                    res.add(nums2[i]);
                }
            }
        }
       int[] r = new int[res.size()];
       for(int i = 0; i < res.size(); i++)
       {
           r[i] = res.get(i);
       }
    
       return r;
    }
}



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) map.put(nums1[i], 1);
            else map.replace(nums1[i], map.get(nums1[i]) + 1);
        }
        int index = 0;
        // System.out.println(map);
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j])) {
                if (map.get(nums2[j]) > 0) {
                    map.replace(nums2[j], map.get(nums2[j]) - 1);
                    res.put(index, nums2[j]);
                    index++;
                }
            }
        }
        // System.out.println(res);
        int[] intersect = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            intersect[k] = (int) res.get(k);
        }
        return intersect;
    }
}