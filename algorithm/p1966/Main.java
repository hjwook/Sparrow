package p1966;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int num = sc.nextInt();

    for (int i = 0; i < num; i++) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int count = 1;
      //0 에는 기존 index, 1에는 중요도
      Queue<int[]> q = new LinkedList<int[]>();

      for (int j = 0; j < N; j++) {
        int input = sc.nextInt();
        q.add(new int[] { j, input });
      }
      int max = 0;
      //최댓값 찾기
      for (int[] item : q) {
        if (max < item[1]) {
          max = item[1];
        }
      }
      while (!q.isEmpty()) {
        //맨 앞이 max값인경우
        if (q.peek()[1] == max) {
          //맨 앞이 찾으려는 인덱스와 같다면 몇번째 pop인지 기록
          if (q.peek()[0] == M) {
            sb.append(Integer.toString(count) + "\n");
            break;
          }
          q.remove();
          count++;
          max = 0;
          //max값 빠졋으니 최댓값 재탐색
          for (int[] item : q) {
            if (max < item[1]) {
              max = item[1];
            }
          }
        } else {
          q.add(q.remove());
        }
      }
    }
    System.out.println(sb);
    sc.close();
  }
}
//1 2 3 4
//2 3 4 1 -- 1
//3 4 1 2 -- 0
//4 1 2 3 -- 3
//1 2 3 -- 2 count 2
//2 3 1 -- 1
//3 1 2 -- 0
