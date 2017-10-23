package _03_Sorting_Advance.InversionNumber;

import java.util.Arrays;

/**
 * Created by mohon on 2017/10/17.
 */
public class InversionCount {
    private InversionCount() {};

    public static long solve(Comparable[] arr) {
        int n = arr.length;
        return solve(arr, 0, n - 1);
    }

    private static long solve(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return 0L;
        }
        int mid = l + (r - l) / 2;
        long res1 = solve(arr, l, mid - 1);
        long res2 = solve(arr, mid + 1, r);
        return res1 + res2 + merge(arr, l, mid, r);
    }

    private static long merge(Comparable[] arr, int l, int mid, int r) {
        // 每次需要合并的都是已经排好序的
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        long res = 0L;
        int i = l + 1, j = mid + 1;
        for (int k = l; k <= j; k++) {
            if (i > r) {
                arr[k] = aux[j - l];
                j++;
            } else if (i < r) {
                arr[k] = aux[i - l];
                i++;
            } else if (arr[i].compareTo(aux[j]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                res += mid - i + 1;
            }
        }
        return res;
    }
}
