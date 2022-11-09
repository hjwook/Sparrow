package p11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] fileSize;

    public static int minCost(int index) {

        return 0;
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
            for (int j = 0; j < inputs.length; j++) {
                fileSize[j] = Integer.parseInt(inputs[j]);
            }

            sb.append(minCost(K));

        }

        System.out.println(sb);
        br.close();
    }
}
