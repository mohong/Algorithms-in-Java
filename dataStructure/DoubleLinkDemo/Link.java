package dataStructure.DoubleLinkDemo;

/**
 * 双向链结点
 */
public class Link {
    public long dDate;
    public Link next;
    public Link previous;

    public Link(long d) {
        dDate = d;
    }

    public void displayLink() {
        System.out.print(dDate + " ");
    }
}
