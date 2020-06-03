class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((q1, q2) -> (q2[0] - q2[1]) - (q1[0] - q1[1]));
        int sum = 0;
        for(int i = 0; i < costs.length; i++) {
            pq.offer(costs[i]);
            if(pq.size() > (costs.length / 2)) {
                sum += pq.poll()[1];
            }
        }
        while(!pq.isEmpty()) {
            sum += pq.poll()[0];
        }
        return sum;
    }
}