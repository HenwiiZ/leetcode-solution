class Solution {
    public int findCircleNum(int[][] M) {
        //一个set记录哪些人已经进入关系网了
        //一个queue把有关系的同学继续加至队尾
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < M.length; i++) {
            if(set.contains(i)) continue;
            set.add(i);
            q.offer(i);
            //至少自己跟自己能形成一个关系网，但是如果之前属于别的关系网会在前面就continue
            res++;
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int j = 0; j < M.length; j++) {
                    if(j == cur) continue;
                    if(M[cur][j] == 1) {
                        if(!set.contains(j)) {
                            set.add(j);
                            q.offer(j);
                        }
                    }
                }
            }
        }
        return res;
    }
}