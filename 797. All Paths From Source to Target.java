class Solution {
    List<List<Integer>> res;
    boolean[] isUsed;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new LinkedList<>();
        isUsed = new boolean[graph.length];
        List<Integer> path = new LinkedList<>();
        for(int i = 0; i < graph.length; i++) {
            path.add(i);
            helper(graph, path, graph[i]);
            path.remove(path.size() - 1);
        }
        return res;
    }
    public void helper(int[][] graph, List<Integer> path, int[] edges) {
        if(edges.length == 0) {
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i < path.size(); i++)
                temp.add(path.get(i));
            if(temp.contains(0) && temp.contains(graph.length - 1)) res.add(temp);
            return;
        }
        for(int i = 0; i < edges.length; i++) {
            int num = edges[i];
            if(isUsed[num]) return;
            else {
                isUsed[num] = true;
                path.add(num);
                helper(graph, path, graph[num]);
                isUsed[num] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}