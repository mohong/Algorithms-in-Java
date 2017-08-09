package leetcode;

/**
 * Created by mohon on 2017/8/9.
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dumyHead = new ListNode(0);
        dumyHead.next = head;
        ListNode cur = dumyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dumyHead.next;
    }
}
