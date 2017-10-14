package _02_Sorting_Basic._06_Insertion_Sort_Advance;

import _02_Sorting_Basic._05_Insertion_Sort.SortTestHelper;

/**
 * 插入排序
 * Created by mohon on 2017/10/14.
 */
public class InsertionSort {

    private InsertionSort() {}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("_02_Sorting_Basic._05_Insertion_Sort.InsertionSort", arr);
    }
}
