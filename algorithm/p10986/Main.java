package p10986;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] arr = new int[N];
    int[] pSum = new int[N + 1];
    int[] mod = new int[M];
    long count = 0;
    for (int i = 0; i < N; i++) {
      arr[i] = (sc.nextInt()) % M;
      pSum[i + 1] = (pSum[i] + arr[i]) % M;
      //각 나머지별 갯수 카운트
      mod[pSum[i + 1]]++;
    }
    //누적합이 바로 나누어 떨어지는 경우 count
    count += mod[0];
    //2개 조합이 나누어 떨어지는 경우 count
    for (int i = 0; i < M; i++) {
      long n = mod[i];
      count += n * (n - 1) / 2;
    }

    System.out.println(count);
    sc.close();
  }
}
//-->i
//1 2 3 1 2   j
//1 3 6 7 9   j
//  2 5 6 8
//    3 4 6
//      1 3
//        2
//1 0 0 1 0
//  2 2 0 2
//    0 1 0
//      1 0
//        2
//p[0][0] = arr[0]
//p[0][1] = (p[0][0]+arr[1])%M
//p[0][2] = (p[0][1]+arr[2])%M
//p[1][1] = arr[1]
//p[1][2] = (p[1][1] +arr[2])%M
//1 2 3 1
//  0 2 1
//    0 0
//      1
