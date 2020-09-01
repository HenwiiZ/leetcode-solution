class Solution {
    public int heightChecker(int[] heights) {
        int[] clone = new int[heights.length];
        int res = 0;
        for(int i = 0; i < heights.length; i++) clone[i] = heights[i];
        Arrays.sort(clone);
        for(int i = 0; i < heights.length; i++) {
            if(clone[i] != heights[i]) res++;
        }
        return res;
    }
}