package leetcode;

/**
 * Created by mohon on 2017/7/6.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public void insert(int val) {
        ListNode node = new ListNode(val);
        next = node;
    }

    public void display() {
        System.out.print(val + " ");
    }
}
