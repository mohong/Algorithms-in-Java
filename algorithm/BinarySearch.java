package algorithm;

public class BinarySearch {

    private BinarySearch() {}

    public static int find(Comparable[] arr, Comparable target) {
        int l = 0, r = arr.length - 1;
        int mid = l/2 + r/2;
        while (l <= r) {
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }
            if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            }
            if (arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            }
        }
        return -1;
    }
}
