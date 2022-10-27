package p1018;

import java.util.Scanner;

public class Main {
    public static Character[][] board;
    public static int min = 64;

    public static void drawNum(int x1, int x2, int y1, int y2) {

        int count = 0;
        // 마스크의 첫번째 칸의 색이 기준
        Character base = board[x1][y1];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                // 'W' 차례에 'B' 가 오거나, 'B' 차례에 'W'가 오면 count++
                if (board[i][j] != base) {
                    count++;
                }
                // 다음칸은 색이 바뀌므로, 검사할 색 change
                base = (base == 'W' ? 'B' : 'W');
            }
            // 줄바꿈시 색 change
            base = (base == 'W' ? 'B' : 'W');
        }

        count = Math.min(count, 64 - count);// 첫번째 색이 유지되냐 반전되냐 중 count 적은것 선택

        min = Math.min(min, count); // min 갱신
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        board = new Character[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        // 8*8 마스크 속에서
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                drawNum(i, i + 8, j, j + 8);
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
