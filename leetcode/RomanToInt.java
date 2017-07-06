package leetcode;
// https://leetcode.com/problems/roman-to-integer/#/description
public class RomanToInt {
    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        for (char c : arr) {
            switch (c) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
        System.out.println(romanToInt("DCXXI")); //621
    }
}
