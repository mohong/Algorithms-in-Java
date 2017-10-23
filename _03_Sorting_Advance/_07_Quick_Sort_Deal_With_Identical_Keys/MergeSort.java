package _03_Sorting_Advance._07_Quick_Sort_Deal_With_Identical_Keys;

import _03_Sorting_Advance._03_Merge_Sort_Advance.SortTestHelper;

import java.util.Arrays;

/**
 * 归并排序
 * Created by mohon on 2017/10/14.
 */
public class MergeSort {

    private MergeSort() {}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用归并排序，对arr[i, j]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;  // 此处有可能超过int的最大值
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
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
        Integer[] arr = _03_Sorting_Advance._02_Merge_Sort.SortTestHelper.generateRandomArray(N,0, 100000);
        SortTestHelper.testSort("_03_Sorting_Advance._02_Merge_Sort.MergeSort", arr);

    }

}
