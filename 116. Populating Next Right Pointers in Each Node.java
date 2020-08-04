/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node node = root;
        while(node != null && node.left != null) {
            Node n = node;
            n.left.next = n.right;
            while(n.next != null) {
                n.right.next = n.next.left;
                n = n.next;
                n.left.next = n.right;
            }
            node = node.left;
        }
        return root;
    }
}