package p10828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String args[]) throws IOException {
        // Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // int N = sc.nextInt();
        int[] stack = new int[N + 1];
        int top = -1;

        for (int i = 0; i < N; i++) {
            String inputLine = br.readLine();// sc.nextLine();
            String[] inputs = inputLine.split(" ");
            String input = inputs[0];

            if ("push".equals(input)) {
                top++;
                stack[top] = Integer.parseInt(inputs[1]);
            } else if ("pop".equals(input)) {
                if (top < 0) {
                    wr.write("-1\n");
                } else {
                    wr.write(Integer.toString(stack[top]) + "\n");
                    top--;
                }
            } else if ("size".equals(input)) {
                wr.write(Integer.toString(top + 1) + "\n");
            } else if ("empty".equals(input)) {
                wr.write(Integer.toString(top < 0 ? 1 : 0) + "\n");
            } else if ("top".equals(input)) {
                if (top < 0) {
                    wr.write("-1\n");
                } else {
                    wr.write(Integer.toString(stack[top]) + "\n");
                }
            }

        }
        wr.flush();
        wr.close();
    }
}
