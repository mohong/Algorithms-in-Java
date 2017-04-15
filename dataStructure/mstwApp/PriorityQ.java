package dataStructure.mstwApp;

/**
 * 优先级队列
 */
public class PriorityQ {
    private final int SIZE = 20;
    private Edge[] queArray;
    private int size; // 当前边数量
    public PriorityQ() {
        queArray = new Edge[SIZE];
        size = 0;
    }

    public void insert(Edge item) {
        int j;
        for (j = 0; j < size; j++) {
            if (item.distance >= queArray[j].distance) {
                break;  // 找到了要插入的位置
            }
        }
        for (int k = size - 1; k >= j; k--) {
            queArray[k+1] = queArray[k];
        }
        queArray[j] = item;
        size++;
    }
    // 删除最小的一个边，由于已经是从大到小的排序了，所以只删除最后一个
    public Edge removeMin() {
        return queArray[--size];
    }
    // 删除指定位置的一条边
    public void removeN(int n) {
        for (int j=n; j < size - 1; j++) {
            queArray[j] = queArray[j + 1];
        }
        size--;
    }
    // 查看最小的一个边
    public Edge peekMin() {
        return queArray[size - 1];
    }
    // 当前边的数量
    public int size() {
        return size;
    }
    // 当前数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    // 查看指定的边
    public Edge peekN(int n) {
        return queArray[n];
    }
    public int find(int findDex) {
        for (int j = 0; j < size; j++) {
            if (queArray[j].descVert == findDex) {
                return j;  // 找到了
            }
        }
        return -1;  // 没找到
    }
}
