package _02_LinkList;

/**
 * 结点
 * Created by mohon on 2017/9/20.
 */
public class Link {
    public int iDate;
    public double dDate;
    public Link next;           //下一个结点的引用

    public Link(int id, double dd) {
        iDate = id;
        dDate = dd;
    }

    public void displayLink(){
        System.out.print("{"+iDate+","+dDate+"}");
    }
}
