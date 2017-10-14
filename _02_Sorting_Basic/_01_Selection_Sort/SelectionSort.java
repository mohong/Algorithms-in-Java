package _02_Sorting_Basic._01_Selection_Sort;

/**
 * 选择排序法
 * Created by mohon on 2017/10/12.
 */
public class SelectionSort {

    // 我们的算法类不允许产生任何实体，所以将构造函数私有化可以避免被创建对象
    private SelectionSort() {}

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间里的最小值索引
            int mixIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mixIndex]) {
                    swap(arr, j, mixIndex);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
