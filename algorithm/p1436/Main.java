package p1436;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 0;
        int i = 1;
        while (true) {
            String temp = Integer.toString(i);
            if (temp.contains("666")) {
                count++;
            }
            if (N == count) {
                break;
            }
            i++;
        }

        System.out.println(i);
        sc.close();
    }
}
