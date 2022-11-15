package p1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] map;
    public static int[][] dp;
    public static int M;
    public static int N;

    // 0,0 ~ i-1,j-1 까지 가는 경로의 갯수 (마스킹 씌워서, 1,1~i,j 까지 가는 경로 갯수)
    public static int cntRoute(int i, int j) {
        // 마스킹된곳 까지 경로는 0개
        if (i == 0 || i == M + 1 || j == 0 || j == N + 1) {
            return 0;

        }
        // 1,1 ~ 1,1 까지 1개
        else if (i == 1 && j == 1) {
            return 1;
        }
        // 계산하지 않았던 곳이면
        if (dp[i][j] == -1) {
            // 위,아래,양,옆 중 자신보다 큰 곳의 경로수 누적합.
            int temp = 0;
            if (map[i - 1][j] > map[i][j]) {
                temp += cntRoute(i - 1, j);
            }
            if (map[i + 1][j] > map[i][j]) {
                temp += cntRoute(i + 1, j);
            }
            if (map[i][j - 1] > map[i][j]) {
                temp += cntRoute(i, j - 1);
            }
            if (map[i][j + 1] > map[i][j]) {
                temp += cntRoute(i, j + 1);
            }
            dp[i][j] = temp;
        }
        return dp[i][j];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputs = input.split(" ");

        M = Integer.parseInt(inputs[0]);
        N = Integer.parseInt(inputs[1]);

        map = new int[M + 2][N + 2];
        dp = new int[M + 2][N + 2];

        for (int i = 0; i < M + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                map[i][j] = 10001;
                dp[i][j] = -1;
            }
        }
        for (int i = 1; i <= M; i++) {
            input = br.readLine();
            inputs = input.split(" ");

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(inputs[j - 1]);
            }
        }
        System.out.println(cntRoute(M, N));
        br.close();
    }
}
