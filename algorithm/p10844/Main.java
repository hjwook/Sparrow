package p10844;

import java.util.Scanner;

public class Main {
    public static int divide = 1000000000;
    public static int[][] memo = new int[101][10];

    public static int stairNum(int N, int F) {
        if (F < 0)
            return 0;
        if (F > 9)
            return 0;
        if (N <= 1)
            return 1;

        if (memo[N][F] == 0)
            memo[N][F] = (stairNum(N - 1, F - 1) + stairNum(N - 1, F + 1)) % divide;

        return memo[N][F];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int result = 0;

        for (int i = 1; i <= 9; i++) {
            result += stairNum(N, i);
            result %= divide;
        }

        System.out.println(result);

        sc.close();

    }
}

//