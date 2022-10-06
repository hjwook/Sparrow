package p1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<Integer>();

        // 가장 높았던 수 저장
        int max = 0;

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            // max보다 입력이 크다면 차이만큼 push
            if (max < input) {
                for (int j = max + 1; j <= input; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                max = input;
            }
            // 아닌경우엔, stack의 top 과 입력 일치하지 않으면 불가
            else if (stack.peek() != input) {
                System.out.println("NO");
                sc.close();
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
        sc.close();
    }
}

// 1 2
// 4 3