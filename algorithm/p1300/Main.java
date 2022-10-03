package p1300;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    //B[k] = x --> x보다 작거나 같은 원소 갯수가 K개
    //즉 , k가 주어졋을때 x 찾기
    //--> x를 움직이며 K가 찾아지나 보기.
    long low = 1;
    long high = K; ///X 는 K를 넘길 수 없음

    while (low < high) {
      long mid = (high + low) / 2;

      int count = 0;
      //각 층별로 mid 와 같거나 작은 숫자가 몇개씩 있는가.
      for (int i = 1; i <= N; i++) {
        count += Math.min(mid / i, N);
      }
      //갯수가 많으면, high를 내리고
      if (count >= K) {
        high = mid;
      }
      //갯수가 적으면, low를 올린다.
      else {
        low = mid + 1;
      }
    }

    System.out.println(low);

    sc.close();
  }
}
// 1 2  3  4  5
// 2 4  6  8  10
// 3 6  9  12 15
// 4 8  12 16 20
// 5 10 15 20 25
//3층 1.3 2.2 3.1
