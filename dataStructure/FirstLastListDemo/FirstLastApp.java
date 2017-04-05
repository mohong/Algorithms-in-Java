package dataStructure.FirstLastListDemo;

/**
 * 双端链表应用
 */
public class FirstLastApp {
    public static void main(String[] args) {
        FirstLastList list = new FirstLastList();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);

        list.insertLast(70);
        list.insertLast(80);
        list.insertLast(90);

        list.deleteFirst();

        list.displayList();
    }
}
