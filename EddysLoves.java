import java.util.Scanner;

public class EddysLoves {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double n = in.nextDouble();
            int count = 0;
            for (double m = 2; m <=n; m++) {
                for (double k = 2; k <=n; k++) {
                    if (Math.pow(m, k) <= n) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
