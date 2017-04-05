package dataStructure.TreeDemo;

public class Node {
    public int iDate;
    public double dDate;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.print("{"+iDate+","+dDate+"}");
    }
}
