class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p2[0] == p1[0]? p1[1] - p2[1]: p2[0] - p1[0]);
        // int[][] res = new int[people.length][2];
        List<int[]> res = new ArrayList<int[]>();
        for(int[] p: people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][2]);
    }
}