package p15828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<Integer>();
        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == -1) {
                break;
            } else if (input == 0) {
                q.poll();
            } else {
                // 버퍼 꽉찰시 버림
                if (q.size() >= N) {
                    continue;
                } else {
                    q.add(input);
                }
            }
        }
        if (q.isEmpty()) {
            sb.append("empty");
        } else {
            for (Integer item : q) {
                sb.append(item + " ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
