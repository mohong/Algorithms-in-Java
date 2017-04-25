package leetcode;

import java.util.ArrayList;

/**
 *
 * Created by mohon on 2017/4/25.
 */
public class Solution {
    public static int[] arr = {0, 1, 0, 3};
    public static void main(String[] args) {
        moveZeroes(arr);
    }

    public static void moveZeroes(int[] nums) {
        int k = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
               if (i != k) {
                   temp = nums[i];
                   nums[i] = nums[k];
                   nums[k++] = temp;
               } else {
                   k++;
               }
            }
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j]);
        }
    }
}
