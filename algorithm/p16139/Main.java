package p16139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 스캐너로 하면 50점이라 bufferedReader로 변경
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        // 알파벳 갯수만큼 누적합 구하기
        int[][] pSum = new int[S.length() + 1][26];
        pSum[0][S.charAt(0) - 'a']++;
        for (int i = 1; i < S.length(); i++) {
            int curChar = S.charAt(i) - 'a';

            for (int j = 0; j < 26; j++) {
                pSum[i][j] = pSum[i - 1][j];
            }
            pSum[i][curChar]++;
        }

        // 구해놓은 누적합으로 부분합 구하기
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (l == 0) {
                sb.append(Integer.toString(pSum[r][index]) + "\n");
            } else {
                sb.append(Integer.toString(pSum[r][index] - pSum[l - 1][index]) + "\n");
            }
        }
        System.out.println(sb);
    }
}
