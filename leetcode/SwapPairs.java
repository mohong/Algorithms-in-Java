package leetcode;


/**
 * Created by mohon on 2017/8/9.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dumyHead = new ListNode(0);
        dumyHead.next = head;
        ListNode p = dumyHead;
        while (p.next !=null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }
        return dumyHead.next;
    }
}
