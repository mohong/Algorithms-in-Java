package _04_Heap._05_Heapify;

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

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MaxHeap(Item[] arr) {
        int n = arr.length;
        data = (Item[]) new Comparable[n + 1];
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
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
        while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }
    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public Item extractMax() {
        assert count > 0;
        Item ret = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        while ( 2 * k <= count) {
            int j = 2 * k;  // 在此轮循环中,data[k]和data[j]交换位置
            if (j+1 <= count && data[j].compareTo(data[j + 1]) < 0) {
                j++; // data[j] 是 data[2*k]和data[2*k+1]中的最大值
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k,j);
            k = j;
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

        maxHeap.extractMax();
        System.out.println(maxHeap.size());
    }
}

