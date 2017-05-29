import java.util.Scanner;

public class Actress {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] a = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            int max = Math.abs(a[0][0]);
            int x = 1, y = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (Math.abs(a[i][j]) > Math.abs(max)) {
                        max = a[i][j];
                        x = j + 1;
                        y = i + 1;
                    }
                }
            }
            System.out.print(y + " " + x + " " + max);
            System.out.println();
        }
    }
}
