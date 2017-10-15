package _02_Sorting_Basic.Optional_01_Bubble_Sort;

/**
 * 冒泡排序
 * Created by mohon on 2017/10/14.
 */
public class BubbleSort {

    private BubbleSort() {}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("_02_Sorting_Basic.Optional_01_Bubble_Sort.BubbleSort", arr);
    }
}
