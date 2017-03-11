import java.util.Scanner;

public class TheDay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] str = s.split("/");
            int year = Integer.parseInt(str[0]);
            int mon = Integer.parseInt(str[1]);
            int day = Integer.parseInt(str[2]);
            int a = 0;
            int ans = 0;
            if (year % 4 == 0 && year % 100 !=0 || year % 400 == 0) {
                a = 1;
            }
            for (int i = 0; i < mon - 1; i++) {
                ans += m[i];
            }
            ans += day;
            System.out.println(ans);
        }
    }
}
