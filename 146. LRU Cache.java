class LRUCache {
    static class DNode {
        private int key;
        private int val;
        DNode pre;
        DNode next;
        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private int capacity;
    private Map<Integer, DNode> map;
    private DNode head;
    private DNode tail;

    public void insertHead(DNode cur) {
        cur.next = head.next;
        head.next.pre = cur;
        cur.pre = head;
        head.next = cur;        
    }
    
    public void deleteTail(DNode cur) {
        cur.next.pre = cur.pre;
        cur.pre.next = cur.next;        
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DNode(-1, -1);
        this.tail = new DNode(-1, -1);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else {
            DNode cur = map.get(key);
            deleteTail(cur);
            insertHead(cur);
            return cur.val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DNode cur = map.get(key);
            cur.val = value;
            deleteTail(cur);
            insertHead(cur);           
            return;
        }
        if(map.size() < capacity) {
            DNode cur = new DNode(key, value);
            map.put(key, cur);
            cur.next = head.next;
            head.next.pre = cur;
            cur.pre = head;
            head.next = cur;
        }
        else {
            DNode del = tail.pre;
            deleteTail(del);
            map.remove(del.key);
            DNode cur = new DNode(key, value);
            insertHead(cur);
            map.put(key, cur);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */