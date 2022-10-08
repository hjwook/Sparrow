package p10866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine()); // int N = sc.nextInt();
    int[] queue = new int[N * 2 + 2];
    int front = N;
    int back = N - 1;

    for (int i = 0; i < N; i++) {
      String inputLine = br.readLine(); // sc.nextLine();
      String[] inputs = inputLine.split(" ");
      String input = inputs[0];

      if ("push_back".equals(input)) {
        back++;
        queue[back] = Integer.parseInt(inputs[1]);
      } else if ("push_front".equals(input)) {
        front--;
        queue[front] = Integer.parseInt(inputs[1]);
      } else if ("pop_front".equals(input)) {
        if (back < front) {
          wr.write("-1\n");
        } else {
          wr.write(Integer.toString(queue[front]) + "\n");
          front++;
        }
      } else if ("pop_back".equals(input)) {
        if (back < front) {
          wr.write("-1\n");
        } else {
          wr.write(Integer.toString(queue[back]) + "\n");
          back--;
        }
      } else if ("size".equals(input)) {
        wr.write(Integer.toString(back - front + 1) + "\n");
      } else if ("empty".equals(input)) {
        wr.write(Integer.toString((back - front + 1) == 0 ? 1 : 0) + "\n");
      } else if ("front".equals(input)) {
        if (back < front) {
          wr.write("-1\n");
        } else {
          wr.write(Integer.toString(queue[front]) + "\n");
        }
      } else if ("back".equals(input)) {
        if (back < front) {
          wr.write("-1\n");
        } else {
          wr.write(Integer.toString(queue[back]) + "\n");
        }
      }
    }
    wr.flush();
    wr.close();
  }
}
