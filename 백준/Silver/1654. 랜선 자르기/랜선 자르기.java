import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static int[] lines;
  public static long max = 0;
  public static long min = 0;
  public static int K;
  public static int N;

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);

    K = sc.nextInt();
    N = sc.nextInt();

    lines = new int[K];

    //max값은 랜선 중 가장 긴 값으로.
    for (int i = 0; i < K; i++) {
      lines[i] = sc.nextInt();
      if (max < lines[i]) {
        max = lines[i];
      }
    }
    max++; //max 를 1을 더 잡아 mid 가 0 으로 나뉘어지는 경우 방지.
    long mid = 0;
    while (min < max) {
      mid = (max + min) / 2;
      int possibleLines = 0;

      for (int i = 0; i < lines.length; i++) {
        possibleLines += lines[i] / mid;
      }
      if (possibleLines >= N) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    //1을 + 했던걸 다시 빼줌
    System.out.println(min - 1);

    sc.close();
  }
}