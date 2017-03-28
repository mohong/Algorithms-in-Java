import java.util.Scanner;

// 1094
public class APlusB6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
