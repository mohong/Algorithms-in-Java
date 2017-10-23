package _03_Sorting_Advance._06_Quick_Sort_Deal_With_Nearly_Ordered_Array;

import _03_Sorting_Advance._03_Merge_Sort_Advance.SortTestHelper;

/**
 * 插入排序
 * Created by mohon on 2017/10/15.
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

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > l && arr[j - 1].compareTo(e) > 0; j--) {
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
        int N = 1000000;
        Integer[] arr = _03_Sorting_Advance._03_Merge_Sort_Advance.SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr1 = _03_Sorting_Advance._03_Merge_Sort_Advance.SortTestHelper.generateNearlyOrderedArray(N, 10);

        // SortTestHelper.testSort("_03_Sorting_Advance._03_Merge_Sort_Advance.InsertionSort", arr);
        SortTestHelper.testSort("_03_Sorting_Advance._03_Merge_Sort_Advance.InsertionSort", arr1);
        // sort(arr, 0, N - 1);
        // System.out.println(SortTestHelper.isSorted(arr));
    }
}
