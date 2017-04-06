package dataStructure.DBFSApp;

public class DFSApp {
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
        theGraph.addEdge(1, 3);  // BD连接
        theGraph.addEdge(3, 4);  // BD连接

        System.out.print("Visits:");
        theGraph.dfs();     // 深度优先搜索
        System.out.println();
    }
}
