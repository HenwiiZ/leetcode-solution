class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(N == 0) return cells;
        Set<String> set = new HashSet<String>();
        int cycle = -1;
        for(int d = 0; d < N; d++) {
            int[] next = nextDay(cells);
            String s = Arrays.toString(next);
            if(set.contains(s)) {
                cycle = d;
                break;
            }
            else{
                set.add(s);
            }
            
            cells = next;
        }
        if(cycle != -1) {
            N %= cycle;
            System.out.println(cycle);
            for(int d = 0; d < N; d++) {
                cells = nextDay(cells);
            }
        }
        return cells;
    }
    public int[] nextDay(int[] cells) {
        int[] res = new int[cells.length];
        for(int i = 1; i < cells.length - 1; i++) {
            if(cells[i - 1] == cells[i + 1])
                res[i] = 1;
            else
                res[i] = 0;
        }
        return res;
    }
}