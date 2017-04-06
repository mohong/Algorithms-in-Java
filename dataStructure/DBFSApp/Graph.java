package dataStructure.DBFSApp;

public class Graph {
    private final int MAXVERTS = 20;
    private Vertex[] vertexList;  // 顶点数组
    private int[][] adjMat;       // 邻接矩阵
    private int nVerts;           // 当前顶点数
    private StackX theStack;      // 深度优先搜索用的栈
    private Queue theQueue;       // 广度优先搜索用的队列

    public Graph() {
        vertexList = new Vertex[MAXVERTS];
        adjMat = new int[MAXVERTS][MAXVERTS];
        nVerts = 0;
        for (int j = 0; j < MAXVERTS; j++) {
            for (int k = 0; k < MAXVERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        theStack = new StackX();
        theQueue = new Queue();
    }
    // 添加顶点
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }
    // 添加边
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    // 显示顶点
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
    // 深度优先搜索
    public void dfs() {
        vertexList[0].wasVisited = true;  // 第一个顶点标志为访问过的
        displayVertex(0);   // 显示访问的顶点
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }
    // 广度优先搜索
    public void bfs() {
        vertexList[0].wasVisited = true;  // 第一个顶点标志为访问过的
        displayVertex(0);   // 显示访问的顶点
        theQueue.insert(0);
        int v2;

        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();   // 从对头取出第一个顶点
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }
    // 获取指定顶点相邻接的一个未被访问过的顶点
    public int getAdjUnvisitedVertex(int v) {
       for (int j = 0; j < nVerts; j++) {
           if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
               return j;    //找到了一个与v顶点相邻接的未访问的顶点位置
           }
       }
        return -1;  // 未找到
    }
}
