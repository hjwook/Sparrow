package p1932;

import java.util.Scanner;

public class Main {

    public static int[][] tri = new int[501][501];
    public static int[][] memo = new int[501][501];

    public static int cost(int floor, int index) {
        if (floor == 0)
            return tri[0][0];

        // index -1 or index

        if (memo[floor][index] == 0) {
            if (index - 1 < 0)
                memo[floor][index] = cost(floor - 1, index) + tri[floor][index];
            else if (floor - 1 < index)
                memo[floor][index] = cost(floor - 1, index - 1) + tri[floor][index];
            else
                memo[floor][index] = Math.max(cost(floor - 1, index - 1), cost(floor - 1, index)) + tri[floor][index];

        }

        return memo[floor][index];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                tri[i][j] = sc.nextInt();

            }

        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (cost(n - 1, i) > max)
                max = cost(n - 1, i);
        }

        System.out.println(max);

        sc.close();

    }
}
