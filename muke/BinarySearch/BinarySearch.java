package muke.BinarySearch;

/**
 * 二分查找
 * Created by mohon on 2017/4/24.
 */
public class BinarySearch {
    public int binarySearch(int[] arr, int n, int target) {
        int l = 0, r = n - 1; // 在[l, r]范围内寻找target
        while (l <= r) {  // 当l = r时，区间[l, r]依然有效
            int mid = ( l + r ) / 2;
            if (arr[mid] == target) {
                return target;
            }
            if (arr[mid] < target) {
                l = mid + 1;
            }
            if (arr[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }
}
