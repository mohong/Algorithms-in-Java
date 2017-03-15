import java.util.Scanner;

public class GradePointAverage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n, m;
            n = in.nextInt();
            m = in.nextInt();
            int[][] a;
            a = new int[100][100];
            double[] b;
            b = new double[100];
            double av = 0, sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j =0 ; j < m; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += a[i][j];
                }
                av = sum / m;
                if(i != n - 1)
                {
                    System.out.printf("%.2f ",av);
                }
                else
                {
                    System.out.printf("%.2f",av);
                }
            }
            System.out.println();
            double sum1 = 0, av1 = 0;
            for (int i = 0; i < m; i++) {
                sum1 = 0;
                for (int j = 0; j < n; j++) {
                    sum1 += a[j][i];
                }
                b[i] = sum1 / n;
                if(i != m - 1)
                {
                    System.out.printf("%.2f ",b[i]);
                }
                else
                {
                    System.out.printf("%.2f",b[i]);
                }
            }
            System.out.println();
            int numberOfStudent = 0;
            for(int c = 0; c < n; c++) {
                boolean ok = true;
                for(int j = 0; j < m; j++) {
                    if(a[c][j] < b[j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    numberOfStudent++;
                }
            }
            System.out.println(numberOfStudent);
            System.out.println();
        }
    }
}
