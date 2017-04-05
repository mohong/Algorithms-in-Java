package dataStructure.TreeDemo;
import java.util.*;

/**
 * 二叉树
 * Created by mohong on 2017/1/27.
 */
public class BiaryTree {
    private Node root;
    public BiaryTree() {
        root = null;
    }

    /**
     * 插入一个结点
     * @param id
     * @param dd
     */
    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iDate = id;
        newNode.dDate = dd;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while(true) {
                parent = current;
                if (id < current.iDate) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 删除一个结点
     * @param key
     * @return
     */
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.iDate != key) {
            parent = current;
            if (key < current.iDate) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;  //没有找到要删除的结点
            }
        }
        if (current.leftChild == null && current.rightChild == null) {   //叶子结点
            if (current == root) {
                root = null;  //删除的是根结点，并且没有子节点
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if(current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {  //要删除的结点只有一个右子节点
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
        }
        return true;
    }

    //向右子节点下找继承者结点
    private Node getSuccessor(Node delNode) {
        Node successParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    /**
     * 查找一个结点
     * @param key
     * @return
     */
    public Node find(int key) {
        Node current = root;
        while (current.iDate != key) {
            if (key < current.iDate) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 遍历二叉树
     * @param traverseType
     */
    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.println("从上至下，从左至右");
                preOrder(root);
                break;
            case 2:
                System.out.println("从下至上，从左到右");
                inOrder(root);
                break;
            case 3:
                System.out.println("从下至上，从右至左");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    //从上至下，从左至右的遍历
    private void preOrder(Node locateRoot) {
        if (locateRoot != null) {
            System.out.print(locateRoot.iDate + " ");
            preOrder(locateRoot.leftChild);
            preOrder(locateRoot.rightChild);
        }
    }

    //从下至上，从左到右
    private void inOrder(Node locateRoot) {
        if (locateRoot != null) {
            inOrder(locateRoot.leftChild);
            System.out.print(locateRoot.iDate + " ");
            preOrder(locateRoot.rightChild);
        }
    }

    //从下至上，从右至左
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println(localRoot.iDate);
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlank = 32;
        boolean isRowEmpty = false;
        System.out.println(" ...........................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlank; j++) {
                System.out.println(" ");
            }
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iDate);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlank*2-2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlank/=2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());

            }
        }
        System.out.println("...............................");
    }
}
