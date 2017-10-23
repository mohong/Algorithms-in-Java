package _04_Heap._05_Heapify;

import java.util.Arrays;

/**
 * Created by mohon on 2017/10/20.
 */
public class Main {
    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("_04_Heap._05_Heapify.HeapSort1", arr1);
        SortTestHelper.testSort("_04_Heap._05_Heapify.HeapSort2", arr2);

    }
}
