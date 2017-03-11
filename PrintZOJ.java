import java.util.Scanner;

public class PrintZOJ {
    public static void main(String[] args) {
        String s = "";
        int count1 = 0, count2 = 0, count3 = 0;
        String[] c = new String[100];
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            s = in.nextLine();
            if ("E".equals(s)) {
                return;
            }
            c = s.split("");
            for (int i = 0; i < c.length; i++) {
                if ("Z".equals(c[i])) {
                    count1++;
                }
                if ("O".equals(c[i])) {
                    count2++;
                }
                if ("J".equals(c[i])) {
                    count3++;
                }
            }
            for (int i = 0; i < c.length; i++) {
                if (count1>0) {
                    System.out.print("Z");
                    count1--;
                }
                if (count2>0) {
                    System.out.print("O");
                    count2--;
                }
                if (count3>0) {
                    System.out.print("J");
                    count3--;
                }
            }
        }
    }
}
