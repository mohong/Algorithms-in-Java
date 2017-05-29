import java.util.Scanner;

// 1095
public class APlusB8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
            sum = 0;
            System.out.println();
        }
    }
}
