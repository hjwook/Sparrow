package p11659;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        // pSum[1] = pSum[0] +a[0];
        int[] pSum = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            pSum[i + 1] = arr[i] + pSum[i];
        }
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            sb.append(Integer.toString(pSum[to] - pSum[from - 1]) + "\n");
        }
        System.out.println(sb);
        sc.close();
    }
}
// 5 4 3 2 1
// 0 5 9 12 14 15
