package leetcode;

/**
 * Created by mohon on 2017/7/5.
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < len - 1; j--){
                    nums[j] = nums[j+1];
                }
                len --;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 5, 4, 5};
        int [] arr2 = {};
        System.out.println(removeElement(arr, -9));
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
