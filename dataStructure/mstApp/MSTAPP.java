package dataStructure.mstApp;

/**
 * 最小生成树
 * Created by mohon on 2017/4/8.
 */
public class MSTAPP {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0, 1);  // AB连接
        theGraph.addEdge(0, 2);  // AC连接
        theGraph.addEdge(0, 3);  // AD连接
        theGraph.addEdge(0, 4);  // AE连接
        theGraph.addEdge(1, 2);  // BC连接
        theGraph.addEdge(1, 3);  // BD连接
        theGraph.addEdge(1, 4);  // BE连接
        theGraph.addEdge(2, 3);  // CD连接
        theGraph.addEdge(2, 4);  // CE连接
        theGraph.addEdge(3, 4);  // CE连接
        theGraph.mst(); // 最小生成树算法
        System.out.println();
    }
}
