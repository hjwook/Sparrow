package p2559;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        int[] pSum = new int[N + 1];
        // 먼저 누적합 배열 생성
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            pSum[i + 1] = pSum[i] + arr[i];
        }
        // K일 연속 온도합 배열 생성
        int[] kpSum = new int[N + 1];
        int max = Integer.MIN_VALUE;
        for (int i = K; i < N + 1; i++) {
            kpSum[i] = pSum[i] - pSum[i - K];
            if (max < kpSum[i]) {
                max = kpSum[i];
            }
        }
        System.out.println(max);
        sc.close();
    }
}
// 3 -2 -4 -9 0 3 7 13 8 -3
// 0 0 0 0 0 -12
// i 가 K 때 pSUm[K+1에] 등록