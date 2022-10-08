package p1021;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int count = 0;
    LinkedList<Integer> dq = new LinkedList<Integer>();
    for (int i = 1; i <= N; i++) {
      dq.add(i);
    }
    for (int i = 0; i < M; i++) {
      int input = sc.nextInt();
      int index = dq.indexOf(input);

      while (index > 0) {
        if (index > dq.size() / 2) {
          dq.addFirst(dq.removeLast());
          index = dq.indexOf(input);
        } else {
          dq.add(dq.remove());
          index = dq.indexOf(input);
        }
        count++;
      }
      dq.remove();
    }
    System.out.println(count);
    sc.close();
  }
}
//1 2 3 4 5 6 7 8 9 10
//2 3 4 5 6 7 8 9 10 1 -- 1
//3 4 5 6 7 8 9 10 1
//9 10 1 3 4 5 6 7 8 -- 3
//10 1 3 4 5 6 7 8
//
