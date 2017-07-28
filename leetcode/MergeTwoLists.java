package leetcode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/#/description
 * Created by mohon on 2017/7/6.
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.insert(4);
        node.insert(9);

    }
}
