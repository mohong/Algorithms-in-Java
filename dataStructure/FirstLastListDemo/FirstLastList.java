package dataStructure.FirstLastListDemo;


/**
 * 双端链表
 * 能纪录第一个链结点和最后一个链结点
 * Created by mohong on 2017/1/20.
 */
public class FirstLastList {
    public Link first;
    public Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 头部插入结点
     * @param dd
     */
    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;  //因为是insertFirst,所以要先插入到头部
        first = newLink;
    }

    /**
     * 尾部插入结点
     * @param dd
     */
    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    /**
     * 删除第一个结点
     * @return
     */
    public long deleteFirst() {
        Link temp = first;
        if (first.next == null) {   //如果只有一个结点，当删除后last也为null
            last = null;
        }
        first = first.next;
        return temp.dData;
    }

    public void displayList() {
        System.out.print("List(first-->last):");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
