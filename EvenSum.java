import java.util.Scanner;
// 2015
public class EvenSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int sum = 0;
            int count = 0;
            int j = 0;
            for (int i = 1; i <= n; i++) {
                j = j + 2;
                sum = sum + j;
                count ++;
                if (i == n) {
                    System.out.println(sum / count);
                } else if (count == m) {
                    System.out.printf("%d ", sum / m);
                    sum = 0;
                    count = 0;
                }
            }
        }
    }
}
