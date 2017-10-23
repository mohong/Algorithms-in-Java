package _04_Heap._05_Heapify;

/**
 * 堆排序
 * Created by mohon on 2017/10/19.
 */
public class HeapSort1 {
    private HeapSort1() {}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap maxHeap = new MaxHeap(n);
        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        SortTestHelper.testSort("_04_Heap._05_Heapify.HeapSort1", arr);
    }
}
