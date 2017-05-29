import java.util.Scanner;
import java.math.*;
// 2001
public class Length {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            double x2 = in.nextDouble();
            double y2 = in.nextDouble();
            double x = x1 - x2;
            double y = y1 - y2;
            double len = Math.sqrt(x * x + y * y);
            System.out.printf("%.2f", len);
            System.out.println();
        }
    }
}
