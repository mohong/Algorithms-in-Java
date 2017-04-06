package dataStructure.DoubleLinkDemo;

/**
 * 双向链表
 * 双向双端链表（有尾指针）
 * Created by mohong on 2017/1/20.
 */
public class DoubleLinkedList {
    private Link first;
    private Link last;

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 从前面插入元素
     * @param dd
     */
    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    /**
     * 从后面插入元素
     * @param dd
     */
    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null) {    //如果只有一个结点，删除后需要把last指针设为null
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    /**
     * 删除最后一个结点
     * @return
     */
    public Link deleteLast() {
        Link temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    /**
     *
     * @param key  要找到的元素
     * @param dd   要插入的元素
     * @return
     */
    public boolean insertAfter(long key, long dd) {
        Link current = first;
        while (current.dDate != key) {
            current = current.next;
            if (current == null) {
                return false;  //退出方法，没有插入成功
            }
        }
        Link newLink = new Link(dd);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;

        return true;
    }

    /**
     * 删除一个结点
     * @param key
     * @return
     */
    public Link deleteKey(long key) {
        Link current = first;
        while (current.dDate != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }

    /**
     * 从前向后打印
     */
    public void displayForward() {
        System.out.print("List(first-->last):");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 从后向前打印
     */
    public void displayBackward() {
        System.out.print("List(last-->first):");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
    }
}
