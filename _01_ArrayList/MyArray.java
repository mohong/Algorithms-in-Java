package _01_ArrayList;

/**
 * 线性表的顺序存储
 * Created by mohon on 2017/9/19.
 */
public class MyArray {
    private long[] array;   //存储元素的数组
    private int nElem;      //元素个数
    private int maxSize;    //数组最大容量
    public MyArray(int size) {
        maxSize = size;
        array = new long[maxSize];
        nElem = 0;
    }

    /**
     * 添加元素
     * @param value
     */
    public void add(long value) {
        array[nElem++] = value;
    }

    /**
     * 通过索引获取元素
     * @param index
     * @return
     */
    public long get(int index) {
        return array[index];
    }

    /**
     * 读取数组中所有元素
     */
    public void getAll() {
        for (int i = 0; i < nElem; i++) {
            System.out.print(array[i] + ",");
        }
    }

    /**
     * 插入元素
     * @param index
     * @param value
     */
    public void insert(int index, long value) {
        for (int i = nElem-1; i >= index; i--) {
            array[i+1] = array[i];
        }
        array[index] = value;
        nElem++;
    }

    /**
     * 删除第i个元素
     * @param index
     * @return
     */
    public long delete(int index) {
        for (int i = index; i < nElem; i++) {
            array[i] = array[i+1];
        }
        nElem--;
        return array[index];
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return nElem == 0;
    }

    /**
     * 是否已满
     * @return
     */
    public boolean isFull() {
        return nElem == maxSize;
    }
}
