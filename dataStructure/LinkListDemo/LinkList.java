package dataStructure.LinkListDemo;

public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    /**
     * 插入一个结点
     * 头插法
     * 始终让新结点在第一的位置
     * @param id
     * @param dd
     */
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id,dd);  //创建一个新的链结点
        newLink.next = first;
        first = newLink;
    }

    /**
     * 删除第一个结点
     * 始终从头往下删除
     * @return
     */
    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return first==null;
    }

    /**
     * 显示链表中的数据
     */
    public void displayList() {
        System.out.print("List(first->last):");
        Link current = first;
        while (current!=null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 查找指定结点
     * @param key
     * @return
     */
    public Link find(int key) {
        Link current = first;
        while (current.iDate != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    /**
     * 删除指定结点
     * @param key
     * @return
     */
    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.iDate != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if(current==first) {  //说明要删除的数据项是第一个
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
}
