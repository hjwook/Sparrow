package p2110;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int C = sc.nextInt();

    int[] coord = new int[N];

    for (int i = 0; i < N; i++) {
      coord[i] = sc.nextInt();
    }

    sc.close();
  }
}
