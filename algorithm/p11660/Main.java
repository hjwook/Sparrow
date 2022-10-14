package p11660;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int[][] pSum = new int[N + 1][N + 1];
    StringBuilder sb = new StringBuilder();
    //0,0 ~ i,j 까지 누적합을 pSUm에 저장
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int input = sc.nextInt();
        pSum[i + 1][j + 1] =
          pSum[i + 1][j] + pSum[i][j + 1] - pSum[i][j] + input;
      }
    }

    for (int i = 0; i < M; i++) {
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();
      //x1,y1 ~ x2,y2 = x2,y2 - x1-1,y2 - x2,y1-1 + x1-1,y1-1
      sb.append(
        Integer.toString(
          pSum[x2][y2] -
          pSum[x1 - 1][y2] -
          pSum[x2][y1 - 1] +
          pSum[x1 - 1][y1 - 1]
        ) +
        "\n"
      );
    }
    System.out.println(sb);
    sc.close();
  }
}
//(2,2)~(3,4)
//p(3,4) - p(3,1) - p(1,4)+p(1,1)
//(3,3)~4,4)
//p(4,4)-p(2,4)-p(4,2)+p(2,2)
//p(x2,y2) - p(x1-1,y2) - p(x2,y1-1) + p(x1-1,y1-1)
//p[i][j] = p[i-1][j] + p[i][j-1] + input
//1 3 6 10
//3 8 15 24
//p[i][j] = p[i][j-1]+arr[i-1][j]+arr[i][j]
