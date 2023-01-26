package p3015;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> beforeFind = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        int[] inputs = new int[N];
        int[] NGI = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = sc.nextInt();
            NGI[i] = N - 1;
        }

        // 입력이 이전입력보다 크면, 오큰수 설정.
        // 오큰수를 결정 못한 대상들과 입력 비교하여 오큰수 설정.
        // 입력이 이전입력보다 크지 않으면 stack push
        // 서로 볼수 있는 쌍의 수를 구하기 위해 인덱스를 저장
        for (int i = 0; i < N - 1; i++) {
            if (inputs[i] < inputs[i + 1]) {
                NGI[i] = i + 1;

                while (!beforeFind.isEmpty() && inputs[beforeFind.peek()] < inputs[i + 1]) {
                    NGI[beforeFind.pop()] = i + 1;
                }
            } else {
                beforeFind.push(i);
            }
        }
        // NGI 순회하며,NGI[i]-i 의 값을 sum
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += NGI[i] - i;
        }
        sb.append(result);
        // for (int i = 0; i < N; i++) {
        // if (i == 0) {
        // sb.append(NGI[i]);
        // } else {
        // sb.append(" ").append(NGI[i]);
        // }
        // }
        System.out.println(sb);
        sc.close();
    }
}