package muke.SelectionSort;

import muke.SortTestHelper;

/**
 * 插入排序
 * Created by mohon on 2017/4/16.
 */
public class InsertSort {
    public static void main(String[] args) {
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 100000;
        int[] arr = sortTestHelper.generateRandomArray(n, 0, n);

        long start = System.currentTimeMillis();
        InsertSort(arr, n);
        // InsertSortAdvance(arr, n);
        float time = (System.currentTimeMillis()-start)/1000f;

        System.out.println(time + "秒");
    }

    // 插入排序法

    public static void InsertSort(int[] arr, int n) {
        int temp;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    // 插入排序法升级
    public static void InsertSortAdvance(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            // 寻找元素arr[i]合适的插入位置
            int e = arr[i];
            int j; // j保存元素e应该插入的位置
            for (j = i; j > 0 && arr[j - 1] > e; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
