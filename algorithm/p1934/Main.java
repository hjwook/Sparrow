package p1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static int gcd(int a, int b) {
    int c;
    while (b > 0) {
      c = a % b;
      a = b;
      b = c;
    }
    return a;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      String input = br.readLine();
      String[] inputs = input.split(" ");
      int A = Integer.parseInt(inputs[0]);
      int B = Integer.parseInt(inputs[1]);

      sb.append(A * B / gcd(A, B)).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}
