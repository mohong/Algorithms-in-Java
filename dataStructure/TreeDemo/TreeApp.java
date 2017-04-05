package dataStructure.TreeDemo;

import java.io.*;

/**
 * Created by mohong on 2017/1/27.
 */
public class TreeApp {

    public static void main(String[] args) throws IOException {
        int value;
        BiaryTree theTree = new BiaryTree();
        theTree.insert(50,1.5);
        theTree.insert(25,1.2);
        theTree.insert(75,1.7);
        theTree.insert(12,1.5);
        theTree.insert(37,1.2);
        theTree.insert(43,1.7);
        theTree.insert(30,1.5);
        theTree.insert(33,1.2);
        theTree.insert(87,1.7);
        theTree.insert(93,1.5);
        theTree.insert(99,1.5);

        while (true) {
            System.out.print("输入一个字符：show,insert find ,delete,or traverse");
            int choice = getChar();
            switch (choice) {
                case 's':  //显示
                    theTree.displayTree();
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
    public static char getChar() throws IOException{
        return getString().charAt(0);
    }
    public static int getInt() throws IOException{
        return Integer.parseInt(getString());
    }
}
