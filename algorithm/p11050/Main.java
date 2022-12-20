package p11050;

import java.util.Scanner;

public class Main {
    public static int[] dp = new int[11];

    public static int facto(int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] == 0) {
            dp[n] = n * facto(n - 1);
        }

        return dp[n];

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(facto(N) / (facto(N - K) * facto(K)));
        sc.close();
    }
}