package p1912;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int number[] = new int[N];
        int dp[] = new int[N];

        number[0] = sc.nextInt();
        dp[0] = number[0];
        int result = dp[0];

        for (int i = 1; i < N; i++) {
            number[i] = sc.nextInt();
            dp[i] = Math.max(dp[i - 1] + number[i], Math.max(number[i - 1] + number[i], number[i]));
            if (result < dp[i])
                result = dp[i];
        }
        System.out.println(result);
        sc.close();

    }
}
