package _03_Sorting_Advance._03_Merge_Sort_Advance;

import java.util.Arrays;

/**
 * 归并排序
 * Created by mohon on 2017/10/14.
 */
public class MergeSort2 {

    private MergeSort2() {}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用归并排序，对arr[i, j]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) { // 优化2: 对于小规模数组, 使用插入排序
            InsertionSort.sort(arr, l, r);
            return;
        }
        int mid = (l + r) / 2;  // 此处有可能超过int的最大值
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    // 将arr[l, mid]和arr[mid+1, r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {  // 如果左半部分处理完(当i++增长到大于mid表示已经到右边了)
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) { // 如果右半部分已经处理完
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j -l]) < 0) { // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {    // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr1 = _03_Sorting_Advance._02_Merge_Sort.SortTestHelper.generateRandomArray(N,0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr1, N);

        SortTestHelper.testSort("_03_Sorting_Advance._03_Merge_Sort_Advance.MergeSort", arr1);
        SortTestHelper.testSort("_03_Sorting_Advance._03_Merge_Sort_Advance.MergeSort2", arr2);

    }

}
