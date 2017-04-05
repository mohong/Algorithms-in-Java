package dataStructure.FirstLastListDemo;

/**
 * 链结点
 * Created by mohong on 2017/1/20.
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long d) {
        dData = d;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
