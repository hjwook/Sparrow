package p2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] weight;

    public static int isPossible(int N) {
        return 0;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N1 = Integer.parseInt(br.readLine());

        weight = new int[N1];
        String input = br.readLine();
        String[] inputs = input.split(" ");

        for (int i = 0; i < N1; i++) {
            weight[i] = Integer.parseInt(inputs[i]);
        }
        int N2 = Integer.parseInt(br.readLine());
        input = br.readLine();
        inputs = input.split(" ");

        for (int i = 0; i < N2; i++) {
            sb.append(isPossible(Integer.parseInt(inputs[i]))).append(" ");
        }

    }
}
