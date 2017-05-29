import java.util.Scanner;
// 2008
public class CountNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                return;
            }
            int a = 0, b = 0, c = 0;
            float[] arr = new float[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextFloat();
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] < 0) {
                    a++;
                } else if (arr[i] == 0) {
                    b++;
                } else if (arr[i] > 0) {
                    c++;
                }
            }
            System.out.println(a + " " + b + " " + c);
        }
    }
}
