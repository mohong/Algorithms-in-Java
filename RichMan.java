import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RichMan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] pa;
        String[] m;
        int total, score;
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            pa = in.nextLine().split(" ");
            total = Integer.parseInt(pa[0]);
            score = Integer.parseInt(pa[1]);
            if (total == 0 && score == 0) {
                break;
            }
            m = in.nextLine().split(" ");
            for (int i = 0; i < total; i++) {
                if (Integer.parseInt(m[i]) >= score) {
                    list.add(Integer.parseInt(m[i]));
                }
            }
            for (int i = list.size()-1; i >= 0 ; i--) {
                System.out.print(list.get(i) + " ");
            }
            list.clear();
            System.out.println();
        }
    }
}
