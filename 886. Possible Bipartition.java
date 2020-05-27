class Solution {
    //save dislike relationships
    //use array[list] will be much easier to add edges than list[list]
    List<Integer>[] edge;
    Map<Integer, Integer> colors = new HashMap<>();
    public boolean possibleBipartition(int N, int[][] dislikes) {
        //initialize: edge is an array with many lists
        edge = new LinkedList[N + 1];
        //so we should make every element in this array a list
        for(int i = 0; i <= N; i++) {
            edge[i] = new LinkedList<Integer>();
        }
        for(int[] dis: dislikes) {
            edge[dis[0]].add(dis[1]);
            edge[dis[1]].add(dis[0]);
        }
        for(int n = 1; n <= N; n++) {
            if(!colors.containsKey(n) && !helper(n, 1)) {
                return false;
            }
        }
        return true;
    }
    public boolean helper(int cur, int color) {
        //if the current vertex has been colored,
        //see whether its color is as expected
        if(colors.containsKey(cur)) {
            return colors.get(cur) == color? true: false;
        }
        //if the current vertex has not been colored,
        //we should color it with the expected color
        colors.put(cur, color);
        //for its neighbor vertices, try whether we could color them with
        //opposite colors
        for(int vertex: edge[cur]) {
            if(!helper(vertex, -color)) {
                return false;
            }
        }
        return true;
    }
}