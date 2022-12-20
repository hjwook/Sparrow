package p11051;

import java.util.Scanner;

public class Main {
    public static int[][] dp;
    public static int div = 10007;

    public static int BC(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }
        if (dp[n][k] == 0) {
            dp[n][k] = (BC(n - 1, k - 1) + BC(n - 1, k)) % div;
        }

        return dp[n][k];

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        dp = new int[N + 1][K + 1];

        System.out.println(BC(N, K));
        sc.close();
    }
}
// 페르마의 소정리
// a^p mod p = a mod p , a * a^(p-2) = 1 mod p --> a^(p-2) mod p 가 a의 역원