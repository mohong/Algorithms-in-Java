package _04_Heap._03_Shift_Up;

/**
 * 最大堆实现
 * Created by mohon on 2017/10/18.
 */
public class MaxHeap<Item extends Comparable> {
    private Item[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        data = (Item[])new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Item item) {
        assert (count < capacity);
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    private void shiftUp(int k) {

        while (k > 1 && data[k].compareTo(data[k / 2]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void swap(int k, int i) {
        Item temp = data[k];
        data[k] = data[i];
        data[i] = temp;
    }


    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );
        System.out.println(maxHeap.size());
    }
}

