import java.util.Scanner;

public class CowStory {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[55];
            if (n == 0) {
                break;
            }
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 3;
            for (int i = 4; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 3];
            }
            System.out.println(arr[n]);
        }
    }
}
