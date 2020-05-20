class StockSpanner {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public StockSpanner() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public int next(int price) {
        int a = 1;
        while(!s1.isEmpty() && s1.peek() <= price) {
            s1.pop();
            a += s2.pop();
        }
        s2.push(a);
        s1.push(price);
        return a;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */