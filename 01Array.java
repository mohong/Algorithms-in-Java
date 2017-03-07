package Array;

public class HighArray {
    private long[] array;
    private int nElems;
    private int maxSize;
    public HighArray(int size) {
        maxSize = size;
        array = new long[maxSize];
        nElems = 0;
    }

    /**
     * 添加元素
     * @param value
     */
    public void add(long value) {
        array[nElems] = value;
        nElems++;
    }

    /**
     * 根据索引查找元素
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
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + ",");
        }
    }

    /**
     * 插入元素
     * @param value
     */
    public void insert(int index, long value) {
        for (int i = nElems - 1; i > index; i--) {
            array[i+1] = array[i];
        }
        array[index] = value;
        nElems++;
    }

    /**
     * 删除第i个元素
     * @param index
     * @return 被删除的元素
     */
    public long delete(int index) {
        for (int i = index; i < nElems - 1; i++) {
            array[i] = array[i+1];
        }
        nElems--;
        return array[index];
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return nElems == 0;
    }

    /**
     * 是否已满
     * @return
     */
    public boolean isFull() {
        return nElems == maxSize;
    }
}
