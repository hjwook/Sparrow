package p25682;

import java.util.Scanner;

public class Main {
    public static boolean[][] board;
    public static int min = 2000 * 2000;
    public static int K;

    public static void drawNum(int x1, int x2, int y1, int y2) {

        int count = 0;
        // 마스크의 첫번째 칸의 색이 기준
        boolean base = board[x1][y1];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                // 'W' 차례에 'B' 가 오거나, 'B' 차례에 'W'가 오면 count++
                boolean cur = board[i][j];
                if (cur != base) {
                    count++;
                }
                // 다음칸은 색이 바뀌므로, 검사할 색 change
                base = !base;
            }
            // 줄바꿈시 색 change 는 K가 짝수일경우만
            if (K % 2 == 0) {
                base = !base;
            }
        }

        count = Math.min(count, K * K - count);// 첫번째 색이 유지되냐 반전되냐 중 count 적은것 선택

        min = Math.min(min, count); // min 갱신
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();
        board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < M; j++) {
                // White = T Black = F
                if (input.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        // K*K 마스크 속에서
        for (int i = 0; i < N - (K - 1); i++) {
            for (int j = 0; j < M - (K - 1); j++) {
                drawNum(i, i + K, j, j + K);
            }
        }
        System.out.println(min);

        sc.close();
    }
}

// W B W B W B
// B W B W B W
// W B W B W B

// W B W
// B B B
// W B W
