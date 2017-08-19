package algorithm;

import java.util.LinkedList;

public class BST<Key extends Comparable<Key>, Value> {

    private class Node{
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;
    private int count;

    public BST() {
        root = null;
        count = 0;
    }
    // 节点数量统计
    public int size() {
        return count;
    }
    // 返回二叉树是否为空
    public boolean isEmpty() {
        return count == 0;
    }
    // 向二分搜索树中添加一个新的节点
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    // 查看二分搜索树中是否存在key
    public boolean contain(Key key) {
        return  contain(root, key);
    }
    // 查看二分搜索树中key对应的value
    public Value search(Key key) {
        return search(root, key);
    }
    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }
    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }
    // 后序遍历
    public void postOrder() {
        postOrder(root);
    }
    // 层序遍历
    public void levelOrder() {
        levelOrder(root);
    }
    // 查找最小key
    public Key minmum() {
        Node minNode = minmum(root);
        return minNode.key;
    }
    // 查找最大key
    public Key maxmum() {
        Node maxNode = maxmum(root);
        return maxNode.key;
    }

    private Node insert(Node node,Key key, Value value) {
        if (node == null) {
            node = new Node(key, value);
            count++;
        }
        if (node.key.compareTo(key) == 0) {
            node.value = value;
        }
        if (node.key.compareTo(key) > 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    private boolean contain(Node root, Key key) {
        if (root == null) {
            return false;
        }
        if (root.key.compareTo(key) == 0) {
            return true;
        }
        if (root.key.compareTo(key) > 0) {
           return contain(root.left, key);
        } else {
           return contain(root.right, key);
        }
    }

    private Value search(Node root, Key key) {
        if (root == null) {
            return null;
        }
        if (root.key.compareTo(key) == 0) {
            return root.value;
        } else if (root.key.compareTo(key) > 0) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value + " ");
        }
    }

    private void levelOrder(Node root) {
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.print(node.value + " ");
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    private Node minmum(Node root) {
        if (root.left == null) {
            return root;
        }
        return minmum(root.left);
    }


    private Node maxmum(Node root) {
        if (root.right == null) {
            return root.right;
        }
        return maxmum(root.right);
    }

}
