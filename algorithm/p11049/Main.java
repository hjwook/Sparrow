package p11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static int[][] matrix;
  public static int[][] dp;

  public static int minCost(int start, int end) {
    //자기 자신인 경우 곱셈 cost 0
    if (start >= end) {
      return 0;
    }
    if (dp[start][end] == 0) {
      int minCost = Integer.MAX_VALUE;
      //자르는 기준 i
      //i로 잘랐을때 왼쪽 행렬과 오른쪽행렬 곱셈들의 최솟값 저장
      for (int i = start; i < end; i++) {
        int temp =
          minCost(start, i) +
          minCost(i + 1, end) +
          matrix[start][0] *
          matrix[i][1] *
          matrix[end][1];
        minCost = Math.min(minCost, temp);
      }
      dp[start][end] = minCost;
    }

    return dp[start][end];
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    dp = new int[N][N];
    matrix = new int[N][2];
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      String[] inputs = input.split(" ");

      matrix[i][0] = Integer.parseInt(inputs[0]);
      matrix[i][1] = Integer.parseInt(inputs[1]);
    }
    System.out.println(minCost(0, N - 1));
    br.close();
  }
}
