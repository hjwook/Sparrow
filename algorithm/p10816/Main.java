package p10816;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  //Scanner 이용시 시간이 초과하여 BufferdWrtier 사용
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      int num = sc.nextInt();
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    int M = sc.nextInt();

    for (int i = 0; i < M; i++) {
      int num = sc.nextInt();
      bw.write((map.containsKey(num) ? map.get(num) : 0) + " ");
      //System.out.print((map.containsKey(num) ? map.get(num) : 0 )+ " ");
    }
    bw.flush();
    bw.close();
    sc.close();
  }
}
//-10 -10 2 3 3 6 7 10 10 10
