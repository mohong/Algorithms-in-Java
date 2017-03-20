import java.util.Scanner;
// 2017
public class StringStatistical {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLine();
            }
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < arr[i].length(); j++) {
                    if (Character.isDigit(arr[i].charAt(j))) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }
}
