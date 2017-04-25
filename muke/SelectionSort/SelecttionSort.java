package muke.SelectionSort;

import muke.SortTestHelper;

/**
 * 选择排序
 * Created by mohon on 2017/4/16.
 */
public class SelecttionSort {
    public static void main(String[] args) {
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 1000000;
        int[] arr = sortTestHelper.generateRandomArray(n, 0, n);
        long start = System.currentTimeMillis();
        selectionSort(arr, n);
        float time = (System.currentTimeMillis()-start)/1000f;
        System.out.println(time + "秒");
        // sortTestHelper.printArray(arr, n);
    }

    // 选择排序
    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
