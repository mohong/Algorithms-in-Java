import java.util.Scanner;

public class CStyle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLine();
            }
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
