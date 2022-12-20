package p1010;

import java.util.Scanner;

public class Main {
    public static int[][] dp = new int[31][31];;

    public static int BC(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }
        if (dp[n][k] == 0) {
            dp[n][k] = (BC(n - 1, k - 1) + BC(n - 1, k));
        }

        return dp[n][k];

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            sb.append(BC(M, N)).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}