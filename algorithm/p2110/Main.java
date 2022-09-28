package p2110;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        int[] routers = new int[N];
        for (int i = 0; i < N; i++) {
            routers[i] = sc.nextInt();
        }

        sc.close();

    }
}

// 1 2 4 8 9

// 1 5 7 10 17 21 25
// 1 25 10 17
