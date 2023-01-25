package p17298;

import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    Stack<Integer> beforeFind = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int N = sc.nextInt();

    int[] inputs = new int[N];
    int[] NGE = new int[N];
    for (int i = 0; i < N; i++) {
      inputs[i] = sc.nextInt();
      NGE[i] = -1;
    }

    //입력이 이전입력보다 크면, 오큰수 설정.
    //오큰수를 결정 못한 대상들과 입력 비교하여 오큰수 설정.
    //입력이 이전입력보다 크지 않으면 stack push
    for (int i = 0; i < N - 1; i++) {
      if (inputs[i] < inputs[i + 1]) {
        NGE[i] = inputs[i + 1];

        while (
          !beforeFind.isEmpty() && inputs[beforeFind.peek()] < inputs[i + 1]
        ) {
          NGE[beforeFind.pop()] = inputs[i + 1];
        }
      } else {
        beforeFind.push(i);
      }
    }

    for (int i = 0; i < N; i++) {
      if (i == 0) {
        sb.append(NGE[i]);
      } else {
        sb.append(" ").append(NGE[i]);
      }
    }
    System.out.println(sb);
    sc.close();
  }
}
