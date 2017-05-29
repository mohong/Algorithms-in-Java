import java.util.Scanner;

public class AgeEighteen {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int sum = 365 * 18;
        while (in.hasNext()) {
            String[] s = in.nextLine().split("-");
            int year = Integer.parseInt(s[0]);
            int mon = Integer.parseInt(s[1]);
            for (int i = 1; i < 18; i++) {
                sum += leapYear(year + i);
            }
            if (mon < 2) {
                sum += leapYear(year);
            }
            if (mon >= 2) {
                sum += leapYear(year + 18);
            }
            System.out.println(sum);
        }
    }
    public static int leapYear(int year) {
        int count;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            count = 1;
            return count;
        } else {
            count = 0;
            return count;
        }
    }
}
