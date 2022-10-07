package p11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                q.add(q.remove());
            }
            if (q.size() == N) {
                sb.append(q.remove());
            } else {
                sb.append(", " + Integer.toString(q.remove()));
            }
        }
        sb.append(">");
        System.out.println(sb);
        sc.close();
    }
}
