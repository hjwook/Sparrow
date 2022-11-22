package p5086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int N1 = Integer.parseInt(inputs[0]);
            int N2 = Integer.parseInt(inputs[1]);

            if (N1 == 0 && N2 == 0) {
                break;
            }

            if (N2 % N1 == 0) {
                sb.append("factor\n");
            } else if (N1 % N2 == 0) {
                sb.append("multiple\n");
            } else {
                sb.append("neither\n");
            }
        }

        System.out.println(sb);
        br.close();

    }

}
