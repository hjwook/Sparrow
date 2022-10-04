package p12015;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    // lis배열에 먼저 A[0] 넣고 셋팅
    int[] lis = new int[N];
    lis[0] = A[0];
    int cnt = 1;
    int low = 0;
    int high = 1;

    for (int i = 1; i < N; i++) {
      // lis의 마지막 원소보다 A[i]가 크다면 그대로 추가
      if (lis[cnt - 1] < A[i]) {
        lis[cnt] = A[i];
        cnt++;
      }
      // lis의 마지막 원소보다 A[i]가 작다면,
      // lis에서 A[i]와 가장 차이가 적은 원소를 찾아교체
      // 교체자리를 찾을때 binary search 사용
      else {
        low = 0;
        high = cnt;
        while (low < high) {
          int mid = (low + high) / 2;
          if (lis[mid] < A[i]) {
            low = mid + 1;
          } else {
            high = mid;
          }
        }
        lis[low] = A[i];
      }
    }
    // 최종 lis 배열의 크기가 정답
    System.out.println(cnt);

    sc.close();
  }
}
//
