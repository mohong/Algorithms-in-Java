package _05_Stack_Link;

/**
 * 链栈的节点
 * Created by mohon on 2017/9/21.
 */

public class Node<E>{
    E e;
    Node<E> next;

    public Node(){}
    public Node(E e, Node next){
        this.e = e;
        this.next = next;
    }
}
