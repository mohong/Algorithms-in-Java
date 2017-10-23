package _05_Binary_Search_Tree._02_Binary_Search_Tree_Basic;

/**
 * 二分搜索树
 * Created by mohon on 2017/10/23.
 */
// 由于Key需要能够进行比较，所以需要extends Comparable<Key>
public class BST<Key extends Comparable<Key>, Value> {
    // 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;  // 根节点
    private int count;  // 树中的节点个数
    // 构造函数, 默认构造一棵空二分搜索树
    public BST() {
        root = null;
        count = 0;
    }
    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }
    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }
}
