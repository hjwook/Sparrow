package p17299;

import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static int max = 1000000;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    Stack<Integer> beforeFind = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int N = sc.nextInt();

    int[] inputs = new int[N];
    int[] NGF = new int[N];
    int[] freq = new int[max + 1];

    for (int i = 0; i < N; i++) {
      inputs[i] = sc.nextInt();
      NGF[i] = -1;
      freq[inputs[i]]++;
    }

    //입력의 빈도가 이전입력빈도보다 크면, 오등큰수 설정.
    //오등큰수를 결정 못한 대상들과 입력빈도 비교하여 오등큰수 설정.
    //입력빈도이 이전입력빈도보다 크지 않으면 stack push
    for (int i = 0; i < N - 1; i++) {
      if (freq[inputs[i]] < freq[inputs[i + 1]]) {
        NGF[i] = inputs[i + 1];

        while (
          !beforeFind.isEmpty() &&
          freq[inputs[beforeFind.peek()]] < freq[inputs[i + 1]]
        ) {
          NGF[beforeFind.pop()] = inputs[i + 1];
        }
      } else {
        beforeFind.push(i);
      }
    }

    for (int i = 0; i < N; i++) {
      if (i == 0) {
        sb.append(NGF[i]);
      } else {
        sb.append(" ").append(NGF[i]);
      }
    }
    System.out.println(sb);
    sc.close();
  }
}
