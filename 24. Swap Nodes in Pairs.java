/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // For this problem, since we need to switch nodes pair by pair,
        // we need a pre to connect the pairs switched before and to be switched.
        if(head == null || head.next == null) return head;
        ListNode left = head;
        ListNode right = head.next;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        head = head.next;
        
        while(right != null) {
            left.next = right.next;
            right.next = left;
            pre.next = right;
            
            ListNode temp = left;
            left = right;
            right = temp;
            
            for(int i = 0; i < 2; i++) {
                if(right == null) return head;
                else right = right.next;
            }
            left = left.next.next;
            pre = pre.next.next;
        }
        return head;
    }
}