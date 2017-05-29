import java.util.Scanner;

public class APlusB9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            if ((m + n) % 86 == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
