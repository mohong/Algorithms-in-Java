package _05_Binary_Search_Tree._01_Binary_Search;

/**
 * 二分查找--递归实现
 * Created by mohon on 2017/10/21.
 */
public class BinarySearch2 {
    private BinarySearch2() {}

    public static int find(Comparable[] arr, Comparable target) {
        return _find(arr, 0, arr.length - 1, target);
    }

    private static int _find(Comparable[] arr, int l, int r, Comparable target) {
        if (l > r) {
            return -1;
        }
        int mid = l/2 + r/2;
        if (arr[mid].compareTo(target) == 0) {
            return mid;
        } else if (arr[mid].compareTo(target) > 0) {
            return  _find(arr, l, mid - 1, target);
        } else {
            return  _find(arr, mid + 1, r, target);
        }
    }

    public static void main(String[] args) {
        int N = 10000;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        int index = BinarySearch2.find(arr, 223);
        System.out.println(index);
    }
}
