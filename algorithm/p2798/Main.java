package p2798;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = sc.nextInt();
        }
        int result = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = Math.max(1, i + 1); j < N - 1; j++) {
                for (int k = Math.max(2, j + 1); k < N; k++) {
                    int tmp = card[i] + card[j] + card[k];
                    if (tmp <= M && tmp > result) {
                        result = tmp;
                    }
                }
            }
        }
        System.out.println(result);
        sc.close();
    }
}
