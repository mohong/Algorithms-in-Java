import java.util.Scanner;
// 2007
public class SqureAndCubic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int x;
            if (m > n) {
                x = m;
                m = n;
                n = x;
            }
            int odd = 0, even = 0;
            for (int i = m; i <= n; i++) {
                if (i % 2 == 0) {
                    even += i * i;
                } else {
                    odd += i * i * i;
                }
            }
            System.out.println(even + " " + odd);
        }
    }
}
