package dataStructure.mstwApp;

/**
 * 带权图最小生成树
 * Created by mohon on 2017/4/15.
 */
public class Graph {
    private final int MAX_SIZE = 20;
    private final int INFINITY = 1000000;  // 无限大，表示没有邻接边
    private Vertex[] vertexList;
    private int[][] adjMat;  // 邻接矩阵
    private int nVerts; // 当前顶点数
    private int currentnVert;  // 当前的顶点
    private PriorityQ thePQ; //最小优先队列
    private int nTree;  // 表示最小生成树算法过程中，标志已访问的顶点的数量

    public Graph() {
        vertexList = new Vertex[MAX_SIZE];
        adjMat = new int[MAX_SIZE][MAX_SIZE];
        nVerts = 0;
        for (int j = 0; j < MAX_SIZE; j++) {
            for (int k = 0; k < MAX_SIZE; k++) {
                adjMat[j][k] = INFINITY;
            }
        }
        thePQ = new PriorityQ();
    }

    // 添加顶点
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }
    // 添加边
    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }
    // 显示顶点
    public void displayVertex(int v) {  // 显示顶点
        System.out.print(vertexList[v].label);
    }
    // 带权图最小生成树
    public void mstw() {
        currentnVert = 0;
        while (nTree < nVerts - 1) {
            vertexList[currentnVert].isInTree = true;  //标志为已访问
            nTree++;
            for (int j = 0; j < nVerts - 1; j++) {
                if (j == currentnVert) {  // 如果遍历到自己，跳过本次循环
                    continue;
                }
                if (vertexList[j].isInTree) {  //到这个点的边已经加入队列了
                    continue;
                }
                int distance = adjMat[currentnVert][j];  // 从邻接矩阵中取出权值
                if (distance == INFINITY) {  // 两点之间没有边
                    continue;
                }
                putInPQ(j, distance);  // 找到边并放入优先级队列中
            }
            if (this.thePQ.size() == 0) {
                System.out.println("Graph not connected");
                return;
            }
            Edge theEdge = thePQ.removeMin(); // 移除队列中最小的边
            int sourceVert = theEdge.srcVert;  // 最下边的源点
            currentnVert = theEdge.descVert;   // 最下边的终点

            // 以下三句打印了一条边
            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentnVert].label);
            System.out.print(" ");
        }
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].isInTree = false;
        }
    }

    public void putInPQ(int newVert, int newDist) {
        int queueIndex = thePQ.find(newDist);
        if (queueIndex != -1) { // 找到了
            Edge tempEdge = thePQ.peekN(queueIndex);
            int oldDist = tempEdge.distance;
            if (oldDist > newDist) {
                thePQ.removeN(queueIndex);  // 删除旧边
                Edge theEdge = new Edge(currentnVert, newDist, newDist);
                thePQ.insert(theEdge);
            }
        } else { // 没有找到
            Edge theEdge = new Edge(currentnVert, newVert, newDist);
            thePQ.insert(theEdge);
        }
    }
}
