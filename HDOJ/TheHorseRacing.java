import java.util.Arrays;
import java.util.Scanner;

// 1052
public class TheHorseRacing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int[] tianJi = new int[n];
            int[] king = new int[n];
            int money = 0;
            for (int i = 0; i < n; i++) {
                tianJi[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                king[i] = in.nextInt();
            }

            Arrays.sort(king);
            Arrays.sort(tianJi);

            int posInKing = 0;
            for (int i = 0; i < n; i++) {
                if (tianJi[i] < king[posInKing]) {
                    money -= 200;
                } else if (tianJi[i] > king[posInKing]) {
                    money += 200;
                    posInKing++;
                } else {
                    money -= 200;
                }
            }
            int strategy1 = money;
            money = 0;

            posInKing = 0;
            for (int i = 0; i < n; i++) {
                if (tianJi[i] < king[posInKing]) {
                    money -= 200;
                } else if (tianJi[i] > king[posInKing]) {
                    money += 200;
                    posInKing++;
                } else {
                    posInKing++;
                }
            }
            int strategy2 = money;
            System.out.println(Math.max(strategy1, strategy2));
        }
    }
}
