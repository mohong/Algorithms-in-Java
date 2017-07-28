package leetcode;

/**
 * Created by mohon on 2017/7/23.
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        if (m == 0 && n != 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        int l = 0, r = 0;
        int[] result = new int[m + n];
        for (int k = 0; k < m + n; k++) {
            if (nums1[l] < nums2[r]) {
                result[k] = nums1[l++];
            } else if (nums1[l] < nums2[r]) {
                result[k] = nums2[r++];
            } else if (l > m) {
                result[k] = nums2[r++];
            } else if (r > n) {
                result[k] = nums1[l++];
            }
        }
    }
}
