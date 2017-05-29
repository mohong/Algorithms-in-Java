import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < arr.length; i++) {
                float r = 0;
                for (int j = 1; j <= arr[i]; j++) {
                    if (j/2 == 0) {
                        r -= 1/j;
                    } else {
                        r += 1/j;
                    }
                    System.out.printf("%.2f", r);
                }
                r = 0;
                System.out.println();
            }
        }
    }
}
