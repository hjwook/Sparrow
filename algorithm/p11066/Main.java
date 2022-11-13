package p11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static int[] fileSize;
  public static int[] fileSum;
  public static int[][] dp;

  //start~end 까지 합치는 비용
  public static int minCost(int start, int end) {
    // start 가 end 보다 크거나 자기자신 합치는 비용 0
    if (start >= end) {
      return 0;
    }
    // 차이가 1이면 단순히 두개 더한값
    else if (Math.abs(start - end) <= 1) {
      return fileSize[start] + fileSize[end];
    }

    if (dp[start][end] == 0) {
      int minCost = Integer.MAX_VALUE;
      // 자르는 기준 i
      for (int i = start; i < end; i++) {
        //자르는기준 왼쪽 + 자르는기준 오른쪽 + 구간합 중 min 값이 dp[start][end]
        int temp =
          minCost(start, i) +
          minCost(i + 1, end) +
          fileSum[end + 1] -
          fileSum[start];
        minCost = Math.min(minCost, temp);
      }
      dp[start][end] = minCost;
    }
    return dp[start][end];
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      int K = Integer.parseInt(br.readLine());
      String input = br.readLine();
      String[] inputs = input.split(" ");

      fileSize = new int[K];
      fileSum = new int[K + 1];
      dp = new int[K][K];
      for (int j = 0; j < inputs.length; j++) {
        fileSize[j] = Integer.parseInt(inputs[j]);
        fileSum[j + 1] += fileSum[j] + fileSize[j];
        // for (int k = 0; k < K; k++) {
        //   dp[j][k] = Integer.MAX_VALUE;
        // }
      }

      sb.append(minCost(0, K - 1)).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}
// 30 30 40 50 20 20
// 40
// 30 30 40 50
// 40 60
// 40 50
// 80 60
// 50
// 80 110
// 190
// 3+6+9+6+9 = 33
// 1 2 3 4 5
// 3 3 4 5
// 6 4 5
// 6 9
// 15
