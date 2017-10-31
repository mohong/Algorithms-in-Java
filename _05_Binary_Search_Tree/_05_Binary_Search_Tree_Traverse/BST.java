package _05_Binary_Search_Tree._05_Binary_Search_Tree_Traverse;

import java.util.LinkedList;

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
    // 插入一个节点
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }
    // 返回插入新节点后的二分搜索树的根
    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) == 0) {
            node.value = value;
        } else if (node.key.compareTo(key) > 0) {
            node.left = insert(node.left, key, value);
        } else if (node.key.compareTo(key) < 0) {
            node.right = insert(node.right, key, value);
        }
        return node;
    }
    // 查看二分搜索树中是否存在键key
    public boolean contain(Key key) {
        return contain(root, key);
    }
    // 查看以node为根的二分搜索树中是否包含键值为key的节点, 使用递归算法
    private boolean contain(Node node, Key key) {
        if (node == null) {
            return false;
        }
        if (node.key.compareTo(key) == 0) {
            return true;
        } else if (node.key.compareTo(key) > 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    public Value search(Key key) {
        return search(root, key);
    }

    private Value search(Node node, Key key) {
        if (node.value == null) {
            return null;
        }
        if (node.key.compareTo(key) == 0) {
            return node.value;
        } else if (node.key.compareTo(key) > 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }
    // 后序遍历
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
    // 层序遍历
    public void levelOrder() {
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.print(node.value);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    // 寻找二分搜索树中的最小键值
    public Key minimun() {
        assert count != 0;
        Node minNode = minimun(root);
        return minNode.key;
    }
    private Node minimun(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimun(node.left);
    }

    // 寻找二分搜索树中的最大键值
    public Key maximun() {
        assert count != 0;
        Node maxiNode = maximun(root);
        return maxiNode.key;
    }
    private Node maximun(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximun(node.right);
    }

    // 从二分搜索树中删除最小值所在的节点
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在的节点
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

}
