import java.util.Scanner;

/**
 * 2021
 */
public class Payoffs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count = 0;
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }
            for (int i =0; i < a.length; i++) {
                while (a[i] >= 100) {
                    a[i] -= 100;
                    count++;
                }
                while (a[i] >= 50) {
                    a[i] -= 50;
                    count++;
                }
                while (a[i] >= 10) {
                    a[i] -= 10;
                    count++;
                }
                while (a[i] >= 5) {
                    a[i] -= 5;
                    count++;
                }
                while (a[i] >= 2) {
                    a[i] -= 2;
                    count++;
                }
                while (a[i] >= 1) {
                    a[i] -= 1;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
