package dataStructure.DBFSApp;

public class Vertex {
    public char label;
    public boolean wasVisited;  // 有无被访问过
    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}
