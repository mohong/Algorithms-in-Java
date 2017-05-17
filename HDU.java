import java.util.Scanner;
// 2500
public class HDU {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            String str = "";
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < arr.length; i++) {
                for (int k = 0; k < arr[i]; k++) {
                    str += "HDU";
                }
                for (int k = 0; k < 3 * arr[i]; k++) {
                    System.out.println(str);
                }
                str = "";
            }
        }
    }
}
