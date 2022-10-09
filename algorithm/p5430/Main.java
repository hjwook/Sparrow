package p5430;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    StringBuilder sb = new StringBuilder();

    while (T-- > 0) {
      String p = sc.nextLine(); //명령어
      int n = Integer.parseInt(sc.nextLine()); //배열크기
      String arr = sc.nextLine(); //배열 문자열
      LinkedList<Integer> dq = new LinkedList<Integer>(); //덱
      Boolean isReverse = false; //뒤집어져있는지 판별
      Boolean isFail = false;
      arr = arr.replaceAll("[\\[\\]]*", "");

      //빈 배열이 아닐 경우에 덱 셋팅
      if (arr.length() > 0) {
        String[] inputs = arr.split(",");

        for (int i = 0; i < inputs.length; i++) {
          dq.add(Integer.parseInt(inputs[i]));
        }
      }
      for (int i = 0; i < p.length(); i++) {
        Character op = p.charAt(i);
        if (op == 'R') {
          isReverse = isReverse ? false : true;
        } else if (op == 'D') {
          if (dq.isEmpty()) {
            sb.append("error\n");
            isFail = true;
            break;
          } else if (isReverse) {
            dq.removeLast();
          } else {
            dq.remove();
          }
        }
      }
      //error가 아닌경우에만
      if (!isFail) {
        sb.append("[");
        while (!dq.isEmpty()) {
          if (dq.size() == 1) {
            //뒤집힌 상태면 마지막부터 remove
            if (isReverse) {
              sb.append(Integer.toString(dq.removeLast()));
            } else {
              sb.append(Integer.toString(dq.remove()));
            }
          } else {
            if (isReverse) {
              sb.append(Integer.toString(dq.removeLast()) + ",");
            } else {
              sb.append(Integer.toString(dq.remove()) + ",");
            }
          }
        }
        sb.append("]\n");
      }
    }
    System.out.println(sb);
    sc.close();
  }
}
