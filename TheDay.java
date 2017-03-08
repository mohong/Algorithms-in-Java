package HDOJ;

/**
 Problem Description
 给定一个日期，输出这个日期是该年的第几天。

 Input
 输入数据有多组，每组占一行，数据格式为YYYY/MM/DD组成，具体参见sample input ,
 另外，可以向你确保所有的输入数据是合法的。

 Output
 对于每组输入数据，输出一行，表示该日期是该年的第几天。

 Sample Input
 1985/1/20
 2006/3/12

 Sample Output
 20
 71

 闰年口诀：四年一闰，百年不闰，400年一闰；
 */

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
