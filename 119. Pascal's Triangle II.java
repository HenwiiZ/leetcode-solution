class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new LinkedList<>();
        cur.add(1);
        if(rowIndex == 0) return cur;        
        cur.add(1);
        if(rowIndex == 1) {
            return cur;
        }
        for(int i = 1; i < rowIndex; i++) {
            List<Integer> next = new LinkedList<>();
            next.add(1);
            for(int j = 0; j < cur.size() - 1; j++) {
                next.add(cur.get(j) + cur.get(j + 1));
            }
            next.add(1);
            cur = next;
        }
        return cur;
    }
}