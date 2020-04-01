class Solution {
    //一个HashMap用于储存先修关系
    //一个Array用于记录一门课有多少先修课，indegree
    //先修课为0的先存入queue，然后依次poll出来
    //并且从HashMap提取上完它后能上什么课，然后让能上的课的indegree-1
    //如果-1后为0，再offer到queue里面
    //最后看是否所有课程indegree为0
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses == 0 || prerequisites.length == 0) return true;
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
        while(!q.isEmpty()) {
            int n = q.poll();
            List<Integer> list = prereq.get(n);
            if (list == null) continue;
            for(int i = 0; i < list.size(); i++) {
                indegree[list.get(i)]--;
                if(indegree[list.get(i)] == 0) q.offer(list.get(i));
            }
        }
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] != 0) return false;
        }
        return true;
    }
}