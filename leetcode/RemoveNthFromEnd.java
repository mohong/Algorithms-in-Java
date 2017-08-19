package leetcode;

/**
 * Created by mohon on 2017/8/11.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hummyHead = new ListNode(0);
        hummyHead.next = head;
        ListNode p = hummyHead;
        ListNode q = hummyHead;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return hummyHead.next;
    }
}
