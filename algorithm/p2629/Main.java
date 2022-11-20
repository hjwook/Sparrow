package p2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] weights;
    public static int N1;
    public static boolean[][] dp;

    // dp[i][j] = i번째 추까지 사용했을때 j 가능 여부
    public static void findAll(int N, int weight) {
        // N,weight 이 입력조건 초과거나, 확인한경우 return
        if (weight > 15000 || dp[N][weight]) {
            return;
        }
        // 현재 보는 weigt 는 가능
        dp[N][weight] = true;
        // 사용하려는 추 갯수가 입력받은 추 갯수일시 탐색 중지.
        if (N >= N1) {
            return;
        }

        // 구슬 반대편에 N번째추를 추가
        findAll(N + 1, weight + weights[N]);
        // N번째 추를 사용하지 않음
        findAll(N + 1, weight);
        // 구슬쪽에 N번째추를 추가
        findAll(N + 1, Math.abs(weight - weights[N]));

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N1 = Integer.parseInt(br.readLine());

        weights = new int[N1];
        String input = br.readLine();
        String[] inputs = input.split(" ");

        for (int i = 0; i < N1; i++) {
            weights[i] = Integer.parseInt(inputs[i]);
        }
        dp = new boolean[31][15001];
        // 0번째추 포함 무게 0 을 시작으로 모두 탐색
        findAll(0, 0);
        int N2 = Integer.parseInt(br.readLine());
        input = br.readLine();
        inputs = input.split(" ");

        for (int i = 0; i < N2; i++) {
            int temp = Integer.parseInt(inputs[i]);
            if (temp > 15000) {
                sb.append("N ");
            } else if (dp[N1][temp]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb);

    }
}
