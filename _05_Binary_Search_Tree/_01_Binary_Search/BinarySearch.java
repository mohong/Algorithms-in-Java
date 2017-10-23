package _05_Binary_Search_Tree._01_Binary_Search;

/**
 * 二分查找--非递归实现
 * Created by mohon on 2017/10/21.
 */
public class BinarySearch {

    private BinarySearch() {}
    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public static int find(Comparable[] arr, Comparable target) {
        // 在arr[l, r]中查找target
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l/2 + r/2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 10000;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        int index = BinarySearch.find(arr, 223);
        System.out.println(index);
    }
}
