package dataStructure.GraphPathApp;

public class Graph {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private int nTree;
    private DistPar[] sPath;
    private int currentVert;
    private int startToCurrent;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = INFINITY;
            }
        }
        sPath = new DistPar[MAX_VERTS];
    }
    // 添加顶点
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }
    // 添加边
    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
    }
    // 最短路径
    public void path() {
        int startTree = 0;
        vertexList[startTree].isInTree = true;
        nTree = 1;
        for (int j = 0; j < nVerts; j++) {
            int tempDist = adjMat[startTree][j];
            sPath[j] = new DistPar(startTree, tempDist);
        }
        while (nTree < nVerts) {
            int indexMin = getMin();
            int minDist = sPath[indexMin].distance;
            if (minDist == INFINITY) {
                System.out.println("There are unreachable vertices");
                break;
            } else {
                currentVert = indexMin;
                startToCurrent = sPath[indexMin].distance;
            }
            vertexList[currentVert].isInTree = true;
            nTree++;
            adjust_sPath();
            displayPaths();
            nTree = 0;
            for (int j = 0; j < nVerts; j++) {
                vertexList[j].isInTree = false;
            }
        }
    }
    public void adjust_sPath() {  // 核心算法
        int colum = 1;
        while (colum < nVerts) {
            if (vertexList[colum].isInTree) {
                colum++;
                continue;
            }
            int currentToFringe = adjMat[currentVert][colum];
            int startToFringe = startToCurrent + currentToFringe;
            int sPathDist = sPath[colum].distance;
            if (startToFringe < sPathDist) {
                sPath[colum].parentVert = currentVert;
                sPath[colum].distance = startToFringe;
            }
            colum++;
        }
    }
    public void displayPaths() {
        for (int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label + "=");
            if (sPath[j].distance == INFINITY) {
                System.out.print("inf");
            } else {
                System.out.print(sPath[j].distance);
            }
            char parent = vertexList[sPath[j].parentVert].label;
            System.out.print("(" + parent + ")");
        }
        System.out.println();
    }
    public int getMin() {  // 从起点开始邻接权值最小的连通的顶点
        int minDist = INFINITY;
        int indexMin = 0;
        for (int j = 0; j < nVerts; j++) {
            if (!vertexList[j].isInTree && sPath[j].distance < minDist) {
                minDist = sPath[j].distance;
                indexMin = j;
            }
        }
        return indexMin;
    }
}
