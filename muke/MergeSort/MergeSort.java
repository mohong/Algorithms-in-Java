package muke.MergeSort;

/**
 * 归并排序
 * Created by mohon on 2017/4/17.
 */
public class MergeSort {

    // 递归使用归并排序，对arr[l...r]的范围进行排序
    public void MergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        MergeSort(arr, l, mid);
        MergeSort(arr, mid + 1, r);
        Merge(arr, l, mid, r);
    }
    // 将arr[l...mid]和arr[mid...r]两部分进行归并
    public void Merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i -l];
                i++;
            } else {
                arr[k] = aux[j -l];
                j++;
            }
        }
    }
}
