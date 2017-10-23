package _04_Heap._05_Heapify;

/**
 * Created by mohon on 2017/10/20.
 */
public class HeapSort2 {
    private HeapSort2() {}

    public static void sort(Comparable[] arr) {
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        SortTestHelper.testSort("_04_Heap._05_Heapify.HeapSort2", arr);
    }
}
