import java.util.Scanner;

// 2002
public class VolumeSphere {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double r = in.nextDouble();
            double V = 4 * 3.1415927 * r * r *r / 3;
            System.out.printf("%.3f", V);
            System.out.println();
        }
    }
}
