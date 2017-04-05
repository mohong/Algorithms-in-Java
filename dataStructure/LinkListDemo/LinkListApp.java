package dataStructure.LinkListDemo;

/**
 * Created by mohong on 2017/1/20.
 */
public class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        theList.insertFirst(99, 9.99);

        while (!theList.isEmpty()){
            Link aLink = theList.deleteFirst();
            System.out.print("deleted");
            aLink.displayLink();
            System.out.println();
        }

        theList.displayList();
    }
}
