package _07_Graph_Basics._04_Read_Graph;

/**
 * 图的接口
 * Created by mohon on 2017/11/20.
 */
public interface Graph {
    int V();
    int E();
    void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    Iterable<Integer> adj(int v);
}
