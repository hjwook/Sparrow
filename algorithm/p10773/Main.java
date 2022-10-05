package p10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < K; i++) {
            int input = sc.nextInt();

            if (input > 0) {
                stack.push(input);
            } else {
                stack.pop();
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
        sc.close();
    }
}
