class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals.length <= 1 || intervals == null) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                else {
                    return o1[0] - o2[0];
                }
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] == start) {
                res++;
                end = Math.max(intervals[i][1], end);
                continue;
            }
            if(intervals[i][1] <= end) res++;
            else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}