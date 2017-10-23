package _04_Heap._02_Max_Heap_Class_Basic;

/**
 * 最大堆实现
 * Created by mohon on 2017/10/18.
 */
public class MaxHeap<Item> {
    private Item[] data;
    private int count;

    public MaxHeap(int capacity) {
        data = (Item[]) new Object[capacity];
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(10);
        System.out.println(maxHeap.size());
        System.out.println(maxHeap.isEmpty());
    }
}

