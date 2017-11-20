package _07_Graph_Basics._02_Graph_Representation;

/**
 * 稠密图--邻接矩阵
 * Created by mohon on 2017/11/12.
 */
public class DenseGraph {

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
    boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }
}
