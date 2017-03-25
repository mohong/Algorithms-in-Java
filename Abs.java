import java.util.Scanner;

// 2003
public class Abs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double n = in.nextDouble();
            if (n > 0) {
                System.out.printf("%.2f", n);
                System.out.println();
            } else {
                System.out.printf("%.2f", -n);
                System.out.println();
            }
        }
    }
}
