class MinStack {

    int minVal;
    LinkedList<Integer> s;
    /** initialize your data structure here. */
    public MinStack() {
        minVal = Integer.MAX_VALUE;
        s = new LinkedList<>();
    }
    
    public void push(int x) {
        if(x < minVal) minVal = x;
        s.offerLast(x);
    }
    
    public void pop() {
        int numPop = s.pollLast();
        if(numPop == minVal) {
            minVal = Integer.MAX_VALUE;
            for(int i = 0; i < s.size(); i++) {
                minVal = Math.min(minVal, s.get(i));
            }
        }
    }
    
    public int top() {
        return s.peekLast();
    }
    
    public int getMin() {
        return minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */