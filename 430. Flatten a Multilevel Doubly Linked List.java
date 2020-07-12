/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        Node cur = head;
        while(cur.next != null || cur.child != null) {
            if(cur.child != null) {
                Node temp = cur.next;
                Node tail = cur.child;
                cur.next = tail;
                tail.prev = cur;
                cur.child = null;
                while(tail.next != null) {
                    tail = tail.next;
                }
                tail.next = temp;
                if(temp != null) temp.prev = tail;
            }
            cur = cur.next;
        }
        return head;
    }
}