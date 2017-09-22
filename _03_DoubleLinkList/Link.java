package _03_DoubleLinkList;

/**
 * 结点
 * Created by mohon on 2017/9/20.
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
