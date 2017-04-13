package dataStructure.topoApp;

public class Graph {
    private final int MAX_VERTXS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;   // 边
    private int nVerts;
    private char[] sorteArray;  // 保存排序后的结果

    public Graph() {
        vertexList = new Vertex[MAX_VERTXS];
        adjMat = new int[MAX_VERTXS][MAX_VERTXS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTXS; j++) {
            for (int k = 0; k < MAX_VERTXS; k++) {
                adjMat[j][k] = 0;
            }
        }
        sorteArray = new char[MAX_VERTXS];
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void display(int v) {
        System.out.println(vertexList[v].label);
    }

    public void topo() {  // 拓扑排序
        int orig_nVertx = nVerts;
        while (nVerts > 0) {
            int currentVertx = noSuccessors();
            if (currentVertx == -1) {  // 找不到没有后继顶点的顶点
                System.out.println("Error: Graph has cycles");
                return; // 退出方法
            }
            sorteArray[nVerts-1] = vertexList[currentVertx].label;
            deleteVertex(currentVertx); // 从图中删除当前顶点
        }
        System.out.print("topo sort order: ");
        for (int j = 0; j < orig_nVertx; j++) {
            System.out.print(sorteArray[j]);
        }
        System.out.println();
    }

    // 查找图中没有后继顶点的顶点
    public int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge) {
                return row;
            }
        }
        return -1;
    }

    // 删除顶点
    public void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) {  // 要删除的顶点不是最后一个就要处理邻接矩阵
            for (int j = delVert; j < nVerts - 1; j++) {
                vertexList[j] = vertexList[j + 1];
            }
            for (int row = delVert; row < nVerts; row++) {
                moveRowUp(row, nVerts);  // 把邻接矩阵中删除行后面的行向上移动
            }
            for (int col = delVert; col < nVerts; col++) {
                moveColLeft(col, nVerts - 1);
            }
        }
        nVerts--;
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }
}
