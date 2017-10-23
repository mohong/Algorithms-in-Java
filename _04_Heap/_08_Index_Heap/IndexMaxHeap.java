package _04_Heap._08_Index_Heap;

import java.util.Arrays;

/**
 * 最大索引堆
 * Created by mohon on 2017/10/21.
 */
public class IndexMaxHeap<Item extends Comparable> {

    protected Item[] data; // 最大索引堆中的数据
    protected int[] indexes; // 最大索引堆中的索引
    protected int count;    // 当前节点的数量
    protected int capacity; // 堆的容量

    public IndexMaxHeap(int capacity) {
        data = (Item[])new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }
    // 索引堆中的元素个数
    public int size() {
        return count;
    }
    // 索引堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }
    // 向最大索引堆中插入一个新元素，新元素的索引为i，元素为item，
    // 传入的i对用户而言，是从0开始的
    public void insert(int i, Item item) {
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        i += 1;
        data[i] = item;
        indexes[count + 1] = i;
        count ++;

        shiftUp(count);
    }
    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k]].compareTo(data[indexes[k / 2]]) > 0) {
            swapIndex(k, k / 2);
            k /= 2;
        }
    }
    // 交换索引堆中的索引
    private void swapIndex(int i, int j) {
        int temp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = temp;
    }

    // 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
    public Item extractMax(){
        assert count > 0;
        Item ret = data[indexes[1]];
        swapIndex(1, count);
        count --;

        shiftDown(1);

        return ret;
    }
    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    private void shiftDown(int k) {
        while (k * 2 <= count) {
            int j = k * 2;  // j表示和父节点交换的那个节点
            if (j + 1 <= count && data[indexes[j+1]].compareTo(data[indexes[k]]) > 0) {
                j ++;
            }
            if (data[indexes[k]].compareTo(data[indexes[j]]) >= 0) {
                break;
            }
            swapIndex(j, k);
            k = j;
        }
    }
    // 从最大索引堆中取出堆顶元素的索引
    public int extractMaxIndex(){
        assert count > 0;
        int ret = indexes[1] - 1;
        swapIndex(1, count);
        count--;
        shiftDown(1);
        return ret;
    }
    // 获取最大索引堆中的堆顶元素
    public Item getMax(){
        assert count > 0;
        return data[indexes[1]];
    }
    // 获取最大索引堆中的堆顶元素的索引
    public int getMaxIndex(){
        assert count > 0;
        return indexes[1] - 1;
    }
    // 获取最大索引堆中索引为i的元素
    public Item getItem( int i ){
        assert i + 1 >= 1 && i + 1 <= capacity;
        return data[i + 1];
    }
    // 将最大索引堆中索引为i的元素修改为newItem
    public void change( int i , Item newItem ){
        i += 1;
        data[i] = newItem;
        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之后shiftUp(j), 再shiftDown(j) (顺序可以颠倒)
        for (int j = 1; j <= count; j++) {
            if (indexes[j] == i) {
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.insert( i , (int)(Math.random()*N) );
        assert indexMaxHeap.testIndexes();
    }

    // 测试索引堆中的索引数组index
    // 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
    public boolean testIndexes(){

        int[] copyIndexes = new int[count+1];

        for( int i = 0 ; i <= count ; i ++ )
            copyIndexes[i] = indexes[i];

        copyIndexes[0] = 0;
        Arrays.sort(copyIndexes);

        // 在对索引堆中的索引进行排序后, 应该正好是1...count这count个索引
        boolean res = true;
        for( int i = 1 ; i <= count ; i ++ )
            if( copyIndexes[i-1] + 1 != copyIndexes[i] ){
                res = false;
                break;
            }

        if( !res ){
            System.out.println("Error!");
            return false;
        }

        return true;
    }
}
