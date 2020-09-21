class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, List<Integer>> pick = new HashMap<>();        
        Map<Integer, List<Integer>> drop = new HashMap<>();
        int count = 0;
        int dest = 0;
        for(int i = 0; i < trips.length; i++) {
            dest = Math.max(dest, trips[i][2]);
            if(pick.containsKey(trips[i][1])) {
                List<Integer> temp =  pick.get(trips[i][1]);
                temp.add(i);
                pick.put(trips[i][1], temp);
            }
            else {
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                pick.put(trips[i][1], temp);
            }
            if(drop.containsKey(trips[i][2])) {
                List<Integer> temp =  drop.get(trips[i][2]);
                // System.out.println(temp.toString());
                // System.out.println(i);
                temp.add(i);
                drop.put(trips[i][2], temp);
            }
            else {
                List<Integer> temp = new LinkedList<>();
                temp.add(i);
                drop.put(trips[i][2], temp);
            }
        }
        for(int i = 0; i < dest; i++) {
            if(drop.containsKey(i + 1)) {
                List<Integer> stops = drop.get(i + 1);              
                for(int s: stops) {
                    count -= trips[s][0];
                }
            }
            if(pick.containsKey(i + 1)) {
                List<Integer> picks = pick.get(i + 1);              
                for(int p: picks) {
                    count += trips[p][0];
                }              
            }
            if(count > capacity) return false;
        }
        return true;
    }
}