class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for(int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if(pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}