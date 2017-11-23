package _07_Graph_Basics._05_DFS_and_Components;

import java.util.Vector;

/**
 * Created by mohon on 2017/11/20.
 */
public class DenseGraph implements Graph {

    private int n; //节点数
    private int m; // 边数
    private boolean directed; // 是否为有向图
    private boolean[][] g;  // 图的具体数据

    // 构造函数
    public DenseGraph(int n, boolean direction) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = direction;
        // g初始化为n*n的不二矩阵，每一个g[i][j]均为false，表示没有任何边
        // 默认为false
        g = new boolean[n][n];
    }

    // 返回节点个数
    public int V() {
        return this.n;
    }
    // 返回边的个数
    public int E() {
        return this.m;
    }
    // 向图中添加一个边
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        if (hasEdge(v,w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }
    // 验证图中是否有从v到w的边
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();
        for(int i = 0 ; i < n ; i ++ )
            if( g[v][i] )
                adjV.add(i);
        return adjV;
    }

}
