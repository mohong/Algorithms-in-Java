import java.util.Scanner;

// 1091
public class APlusB1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <2; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i][0] + arr[i][1]);
            }
        }
    }
}
