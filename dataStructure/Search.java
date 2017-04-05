package dataStructure;

public class Search {
    public static void main(String[] args) {
        int[] arr = {10,20,40,50,70,90};
        int key = binarySearch(arr, 6, 90);
        System.out.println(key);
    }

    public static int binarySearch(int[] a, int n, int key) {
        int low, hight, mid;
        low = 1;
        hight = n;
        while (low <= hight) {
            mid = (low + hight) /2;
            if (key < a[mid]) {
                hight = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}
