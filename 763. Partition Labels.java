class Solution {
    //先用HashMap把所有字母的最后一次出现的坐标记录，
    //然后遍历S，更新endIdx，只有当i == endIdx的时候
    //才用endIdx - startIdx表示长度
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = S.length() - 1; i >= 0; i--) {
            if(!map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), i);
            }
        }
        int startIdx = 0;
        int endIdx = 0;
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            endIdx = Math.max(endIdx, map.get(c));
            if(endIdx == i) {
                endIdx++;
                res.add(endIdx - startIdx);
                startIdx = endIdx;
            }
        }
        return res;
    }
}