import java.util.Scanner;

public class FoolsDayGifts_Skill {
    public static void main(String[] args) {
        String[] s;
        int count = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            s = in.nextLine().split("");
            for (int i = 0; i < s.length; i++) {
                if ("(".equals(s[i])) {
                    count++;
                }
                if ("B".equals(s[i])) {
                    break;
                }
                if (")".equals(s[i])) {
                    count--;
                }
            }
            System.out.println(count);
            count = 0;
        }
    }
}
