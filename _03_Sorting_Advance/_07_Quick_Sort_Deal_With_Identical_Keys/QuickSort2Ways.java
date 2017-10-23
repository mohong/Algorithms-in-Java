package _03_Sorting_Advance._07_Quick_Sort_Deal_With_Identical_Keys;

/**
 * 双路快排————有错误，这个包下面很诡异，
 * Created by mohon on 2017/10/16.
 */
public class QuickSort2Ways {
    private QuickSort2Ways() {}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr, l, (int)Math.random() * (r - l + 1) + l);
        Comparable v = arr[l];
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        return lt;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000);
        // Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, 300);

        SortTestHelper.testSort("_03_Sorting_Advance._07_Quick_Sort_Deal_With_Identical_Keys.QuickSort2Ways", arr);
        // SortTestHelper.testSort("_03_Sorting_Advance._07_Quick_Sort_Deal_With_Identical_Keys.QuickSort2Ways", arr1);
    }
}
