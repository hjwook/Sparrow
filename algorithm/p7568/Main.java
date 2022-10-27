package p7568;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] phy = new int[N][2];

        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            phy[i][0] = sc.nextInt();
            phy[i][1] = sc.nextInt();
        }
        // 자신과 다른 모두를 비교해서 자신보다 큰 덩치 수만큼 count++
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N; j++) {
                if (j == i) {
                    continue;
                }
                if (phy[i][0] < phy[j][0] && phy[i][1] < phy[j][1]) {
                    count++;
                }
            }
            rank[i] = count;
        }
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                System.out.print(rank[i]);
            } else {
                System.out.print(" " + rank[i]);
            }
        }
        sc.close();
    }
}
