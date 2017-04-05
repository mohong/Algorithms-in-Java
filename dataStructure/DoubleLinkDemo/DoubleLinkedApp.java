package dataStructure.DoubleLinkDemo;

/**
 * 双端双向链表应用程序
 * Created by mohong on 2017/1/20.
 */
public class DoubleLinkedApp {
    public static void main(String[] args) {
        DoubleLinkedList theList = new DoubleLinkedList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);

        theList.displayForward();  //从前向后打印
        theList.displayBackward();  //从后向前打印
    }
}
