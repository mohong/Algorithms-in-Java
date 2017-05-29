import java.util.Scanner;

// 2016
public class ChangeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int min = arr[0];
            int index = 0, temp;
            for (int i = 1; i < n; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    index = i;
                }
            }
            temp = arr[index];
            arr[index] = arr[0];
            arr[0] = temp;
            for (int i = 0; i <= n - 2; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[n - 1]);
        }
    }
}
