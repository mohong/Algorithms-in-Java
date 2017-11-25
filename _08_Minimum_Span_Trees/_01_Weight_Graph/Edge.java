package _08_Minimum_Span_Trees._01_Weight_Graph;

/**
 * Created by mohon on 2017/11/23.
 */
public class Edge<Weight extends Number & Comparable> implements Comparable {

    private int a, b; // 边的两个端点
    private Weight weight; // 边的权值

    public Edge(int a, int b, Weight weigth) {
        this.a = a;
        this.b = b;
        this.weight = weigth;
    }

    public Edge(Edge<Weight> edge) {
        this.a = edge.a;
        this.b = edge.b;
        this.weight = edge.weight;
    }

    public int v() {  // 返回第一个顶点
        return a;
    }

    public int w() {  // 返回第二个顶点
        return b;
    }

    public Weight wt () {  // 返回权值
        return weight;
    }

    public int other(int x) {   // 返回另一个边
        assert x == a || x == b;
        return x == a ? b : a;
    }

    // 输出边的信息
    public String toString(){
        return "" + a + "-" + b + ": " + weight;
    }

    public int compareTo(Edge that) {    // 边之间的比较
        if (weight.compareTo(that.wt()) < 0) {
            return -1;
        } else if (weight.compareTo(that.wt()) > 0)
            return 1;
        else {
            return 0;
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
