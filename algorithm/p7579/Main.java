package p7579;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] m = new int[N];
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            m[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            c[i] = sc.nextInt();
        }

        sc.close();
    }
}
