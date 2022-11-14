package p1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int cntRoute() {
        return 0;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String[] inputs = input.split(" ");

        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);

        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            input = br.readLine();
            inputs = input.split(" ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        System.out.println(cntRoute());
        br.close();
    }
}
