/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //如果有环，先slow=fast找出相遇点
    //然后slow从head开始，fast从相遇点开始
    //再相遇就是环的入口了
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode res = null;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                res = slow;
                break;
            }
        }
        if(res != null) {
            slow = head;
            fast = res;
            while(fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        else {
            return res;
        }
    }
}