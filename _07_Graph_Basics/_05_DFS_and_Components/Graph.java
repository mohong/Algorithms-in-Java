package _07_Graph_Basics._05_DFS_and_Components;

/**
 * Created by mohon on 2017/11/21.
 */
public interface Graph {
    int V();
    int E();
    void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    Iterable<Integer> adj(int v);
}
