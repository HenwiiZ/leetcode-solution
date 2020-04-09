/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while(true){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] == null) continue;
                if (min > lists[i].val) {
                    min = lists[i].val;
                    index = i;
                }
            }
            if (index == -1) break;
            else {
                pre.next = lists[index];
                lists[index] = lists[index].next;
                pre = pre.next;
            }
        }
        return preHead.next;
    }
}