package p4949;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static String isBalance(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(input.charAt(i));
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return "no";
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return "no";
                }

            } else if (c == ']') {
                if (stack.isEmpty()) {
                    return "no";
                } else if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return "no";
                }
            }
        }
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input.charAt(0) == '.') {
                break;
            }
            wr.write(isBalance(input) + "\n");

        }
        wr.flush();
        wr.close();

    }
}
