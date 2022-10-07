package p2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.remove();
            queue.add(queue.peek());
            queue.remove();
        }
        System.out.println(queue.peek());
        sc.close();
    }
}