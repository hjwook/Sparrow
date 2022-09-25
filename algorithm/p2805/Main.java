package p2805;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    long max = 0;
    long min = 0;
    long[] trees = new long[N];
    for (int i = 0; i < N; i++) {
      trees[i] = sc.nextInt();
      if (max < trees[i]) {
        max = trees[i];
      }
    }

    long mid = 0;

    while (min < max) {
      mid = (max + min) / 2;
      long sum = 0;
      for (int i = 0; i < N; i++) {
        sum += Math.max(trees[i] - mid, 0);
      }

      if (sum >= M) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    System.out.println(min - 1);

    sc.close();
  }
}
//1 1 20
