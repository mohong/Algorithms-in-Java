package dataStructure;

/**
 * 排序
 * Created by mohong on 2017/2/25.
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = {3,4,7,2,9,6};
        // bubbleSort(arr);
        // selectSort(arr);
        insertSort(arr);
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 2; j >= i; j--) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int min, temp;
        for (int i = 0; i <= arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        for (int i = 0; i <= arr.length-1; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int j, temp;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                temp = arr[i];
                for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
