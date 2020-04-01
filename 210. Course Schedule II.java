class Solution {
    //refer to my 207
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses == 0 || prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++)
                res[i] = i;
            return res;
        }
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> prereq = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < prerequisites.length; i++) {
            if(prereq.containsKey(prerequisites[i][1])) {
                prereq.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            else {
                LinkedList<Integer> temp = new LinkedList<Integer>();
                temp.add(prerequisites[i][0]);
                prereq.put(prerequisites[i][1], temp);
            }
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()) {
            int n = q.poll();
            res[index++] = n;
            List<Integer> list = prereq.get(n);
            if (list == null) continue;
            for(int i = 0; i < list.size(); i++) {
                indegree[list.get(i)]--;
                if(indegree[list.get(i)] == 0) q.offer(list.get(i));
            }
        }
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] != 0) return new int[0];
        }
        return res;        
    }
}