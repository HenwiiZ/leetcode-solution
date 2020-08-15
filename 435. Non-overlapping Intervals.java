class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        int res = 0;
        int idx = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[idx][1] > intervals[i][0]) {
                res++;
                if(intervals[idx][1] > intervals[i][1]) {
                    //不能用idx++
                    idx = i;
                }
            }
            else {
                idx = i;
            }
        }
        return res;
    }
}