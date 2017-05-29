import java.util.Scanner;

// 1092
public class APlusB4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                return;
            }
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        }
    }
}
