package p11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] fileSize;
    public static int[][] memo;

    public static int minCost(int start, int end) {
        // start 가 end 보다 크면 return 0
        if (start > end) {
            return 0;
        }
        // start 와 end index 같으면 단일값
        else if (start == end) {
            return fileSize[start];
        }
        // 차이가 1이면 단순히 두개 더한값
        else if (Math.abs(start - end) <= 1) {
            return fileSize[start] + fileSize[end];
        }

        if (memo[start][end] == 0) {
            // 자르는 기준 정할 mask 크기
            for (int i = 2; i < fileSize.length - 1; i++) {
                // 정해진 mask 크기로 fileSize 배열 iterate
                for (int j = 0; j < fileSize.length - i; j++) {
                    memo[start][end] = minCost(0, j - 1) + minCost(j, j + i - 1) + minCost(j + i, fileSize.length - 1);
                }
            }

        }
        return memo[start][end];
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
            memo = new int[K][K];
            for (int j = 0; j < inputs.length; j++) {
                fileSize[j] = Integer.parseInt(inputs[j]);

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
