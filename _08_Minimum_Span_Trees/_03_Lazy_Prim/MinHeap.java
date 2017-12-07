
public class MinHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    // 构造函数，构造一个空堆，可容纳capacity个元素
    public MinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1]; // 索引从1开始
        count = 0;
        this.capacity = capacity;
    }

    // 构造函数，通过一个给定数组构建一个最小堆
    public MinHeap(Item arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    // 返回堆中元素的个数
    public int size() {
        return count;
    }

    // 返回一个布尔值，表示堆中是否为空
    public boolean isEmpty () {
        return count == 0;
    }

    // 向最小堆中插入一个元素，item
    public void insert(Item item) {
        assert count < capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    // 从最小堆中取出堆顶元素，即堆中所存储的最小元素
    public Item extractMin() {
        assert count > 0;
        Item min = data[1];
        swap(1, count);
        count --;
        shiftDown(1);
        return min;
    }

    // 获取最小堆中堆顶元素
    public Item getMin() {
        assert (count > 0);
        return data[1];
    }

    public void swap(int i, int j) {
        Item temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // **********************
    // 最小堆核心辅助函数
    // **********************
    private void shiftUp(int k) {
        while (k > 1 && data[k/2].compareTo(data[k]) > 0) {
            swap(k/2, k);
            k /= 2;
        }
    }
    private void shiftDown(int k) {
        while (2 * k < count) {
            int j = 2 * k;      // 在此轮循环中，data[k]和data[j]交换位置
            if (j + 1 <= count && data[j].compareTo(data[j + 1]) > 0) {
                j += 1;
            }
            if (data[k].compareTo(data[j]) <= 0) {
                break;
            }
            swap(j, k);
            k = j;
        }
    }

    // 测试MinHeap
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap<Integer>(100);
        int N = 100;   // 堆中元素个数
        int M = 100;   // 堆中元素取值范围
        for (int i = 0; i < N; i++) {
            minHeap.insert(new Integer((int)Math.random() * M));
        }

        Integer[] arr = new Integer[N];

        // 将minHeap中的数据逐步使用extracMin取出来，取出来的结果应该是从小到大排列的
        for (int i = 0; i < N; i++) {
            arr[i] = (Integer) minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从小到大排列的
        for (int i = 0; i < N; i++) {
            assert arr[i - 1] < arr[i];
        }
    }
}