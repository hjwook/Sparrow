package p10986;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] arr = new int[N];
    //맨앞 인덱스부터 하나씩 빼며 누적합%M을 구한다.
    int[][] pSum = new int[N + 1][N + 1];
    int count = 0;
    for (int i = 0; i < N; i++) {
      arr[i] = (sc.nextInt()) % M;
      for (int j = 0; j <= i; j++) {
        pSum[j][i + 1] = (pSum[j][i] + arr[i]) % M;
        //mod M 이 0일시 M으로 나누어 떨어지는 부분구간합
        if (pSum[j][i + 1] == 0) {
          count++;
        }
      }
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
