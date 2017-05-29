import java.util.Scanner;

public class AbsSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int temp;
            for (int i = 0; i <= n - 1; i++) {
                for (int j = n - 2; j >= i; j--) {
                    if (Math.abs(arr[j]) < Math.abs(arr[j + 1])) {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            int i;
            for (i = 0; i <= n - 2; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[n - 1]);
            System.out.println();
        }
    }
}
