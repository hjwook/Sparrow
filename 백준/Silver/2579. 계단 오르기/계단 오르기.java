import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[] score;
    public static int[] dp; //dp[N] = N계단 까지 오를때 최대점수
    
    public static int maxScore(int N) {
        if (N < 0) {
            return 0;
        }
        if (N == 0) {
            dp[N] = score[N];
            return dp[N];
        }
        else if (N == 1) {
            dp[N] = score[N - 1] + score[N];
            return dp[N];
        }
        if (dp[N] == 0) {
            dp[N] = Math.max(maxScore(N - 2) + score[N], maxScore(N - 3) + score[N - 1] + score[N]);
        }
        
        return dp[N];
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        score = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(maxScore(N-1));

    }
}