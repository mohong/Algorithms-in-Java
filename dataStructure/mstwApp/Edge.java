package dataStructure.mstwApp;

public class Edge {
    public int srcVert; // 源点
    public int descVert; // 终点
    public int distance;  //距离

    public Edge(int sv, int dv, int d) {
        srcVert = sv;
        descVert = dv;
        distance = d;
    }
}
