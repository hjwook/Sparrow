package p2579;

import java.util.Scanner;

public class Main {
    public static int[] stair = new int[301];
    public static int[] memo = new int[301];

    public static int cost(int floor) {
        if (floor < 0)
            return 0;
        else if (floor == 0)
            return stair[0];
        else if (floor == 1)
            return stair[0] + stair[1];

        if (memo[floor] == 0) {
            memo[floor] = Math.max(cost(floor - 2) + stair[floor], cost(floor - 3) + stair[floor - 1] + stair[floor]);
        }

        return memo[floor];

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            stair[i] = sc.nextInt();
        }

        System.out.println(cost(n - 1));

        sc.close();

    }
}
