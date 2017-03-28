import java.util.Scanner;

// 1093
public class APlusB5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int m = in.nextInt();
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += in.nextInt();
                }
                arr[i] = sum;
            }
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
