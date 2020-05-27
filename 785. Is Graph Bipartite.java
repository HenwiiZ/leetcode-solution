class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> colors = new HashMap<>();
        for(int i = 0; i <graph.length; i++) {
            if(!colors.containsKey(i) && !helper(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }
    public boolean helper(int[][] graph, Map<Integer, Integer> colors, int cur, int color) {
        if(colors.containsKey(cur)) {
            if(colors.get(cur) == color) {
                return true;
            }
            else {
                return false;
            }
        }
        colors.put(cur, color);
        for(int i = 0; i < graph[cur].length; i++) {
            if(!helper(graph, colors, graph[cur][i], -color)) {
                return false;
            }
        }
        return true;
    }
}