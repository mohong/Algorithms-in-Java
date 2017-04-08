package dataStructure.mstApp;

import dataStructure.DBFSApp.Queue;
import dataStructure.DBFSApp.StackX;
import dataStructure.DBFSApp.Vertex;

public class Graph {
    private final int MAXVERTS = 20;
    private Vertex[] vertexList;  // 顶点数组
    private int[][] adjMat;       // 邻接矩阵
    private int nVerts;           // 当前顶点数
    private StackX theStack;      // 深度优先搜索用的栈

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
    // 最小生成树
    public void mst() {
        vertexList[0].wasVisited = true;
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) {  // 没有找到邻接的没有访问过的顶点
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                theStack.push(v);
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = true;
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
