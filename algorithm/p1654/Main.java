package p1654;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

  //Scanner 이용시 시간이 초과하여 BufferdWrtier 사용
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();
    int N = sc.nextInt();

    int[] lines = new int[K];

    for (int i = 0; i < K; i++) {
      lines[i] = sc.nextInt();
    }
    sc.close();
  }
}
//-10 -10 2 3 3 6 7 10 10 10
