import java.util.Scanner;

/**
 * 2019
 */
public class ChooseSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int j;
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] < m) {
                    for (j = n - 1; j > i; j --) {
                        arr[j + 1] = arr[j];
                    }
                    arr[i + 1] = m;
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[n]);
            System.out.println();
        }
    }
}
