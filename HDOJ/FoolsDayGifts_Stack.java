import java.util.Scanner;
import java.util.Stack;

public class FoolsDayGifts_Stack {
    public static void main(String[] args) {
        Stack<String> s = new <String>Stack();
        String[] m;
        int count = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            m = in.nextLine().split("");
            for (int i = 0; i < m.length; i++) {
                if ("(".equals(m[i])) {
                    s.push(m[i]);
                }
                if (")".equals(m[i])) {
                    s.pop();
                }
                if ("B".equals(m[i])) {
                    break;
                }
            }
            while (!s.empty()) {
                count++;
                s.pop();
            }
            System.out.println(count);
            count = 0;
        }
    }
}
