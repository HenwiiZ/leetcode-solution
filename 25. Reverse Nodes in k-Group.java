/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        for(int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        
        while(fast != null) {
            ListNode tmp = fast.next;
            fast.next = null;
            ListNode r = reverseList(slow);
            cur.next = r;
            while(r.next != null) {
                r = r.next;
                cur = r;
            }        
            r.next = tmp;
            slow = r.next;
            fast = r.next;
            for(int i = 0; i < k - 1; i++) {
                if (fast != null) fast = fast.next;
                else return res.next;
            }
        }
        return res.next;
        
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while(cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}