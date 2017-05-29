import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 2010
public class Daffodil {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            List list = new ArrayList();
            for (int i = m ; i <= n; i++) {
                int a = i / 100;
                int b = (i % 100) / 10;
                int c= i % 100 % 10;
                if (i == a * a * a + b * b * b + c * c * c) {
                    list.add(i);
                }
            }
            if (list.isEmpty()) {
                System.out.println("no");
            } else {
                for (int i = 0; i < list.size() - 1; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println(list.get(list.size() - 1));
            }
        }
    }
}
