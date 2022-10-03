package p2110;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static int N, C;
  public static int[] coord;

  public static boolean canInstall(int distance) {
    int lastIndex = 0;
    int cnt = 1;
    for (int i = 1; i < N; i++) {
      if (coord[i] - coord[lastIndex] >= distance) {
        lastIndex = i;
        cnt++;
      }
    }

    if (cnt >= C) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    C = sc.nextInt();

    coord = new int[N];

    for (int i = 0; i < N; i++) {
      coord[i] = sc.nextInt();
    }

    Arrays.sort(coord);

    int lowBound = 1;
    int upBound = coord[N - 1] - coord[0] + 1;

    while (lowBound < upBound) {
      int mid = (lowBound + upBound) / 2;

      if (canInstall(mid)) {
        lowBound = mid + 1;
      } else {
        upBound = mid;
      }
    }

    System.out.println(lowBound - 1);

    sc.close();
  }
}
//1 2 3 4 5 6 20
//0 1 2 3 4 5 6
