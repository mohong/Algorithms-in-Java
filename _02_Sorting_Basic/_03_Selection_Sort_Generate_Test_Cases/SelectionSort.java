package _02_Sorting_Basic._03_Selection_Sort_Generate_Test_Cases;

/**
 * 选择排序法
 * Created by mohon on 2017/10/12.
 */
public class SelectionSort {

    // 我们的算法类不允许产生任何实体，所以将构造函数私有化可以避免被创建对象
    private SelectionSort() {}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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
        SelectionSort.sort(arr);
        SortTestHelper.printArray(arr);
    }
}
