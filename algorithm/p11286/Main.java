package p11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                // 절댓값기준 최소힙으로 오름차순 정렬하도록 구성
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (Math.abs(o1) > Math.abs(o2)) {
                            return 1;
                        }
                        // 절댓값이 같다면, 음수를 앞으로
                        else if (Math.abs(o1) == Math.abs(o2)) {
                            return o1 - o2;
                        } else {
                            return -1;
                        }
                    }
                });
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.size() == 0) {
                    sb.append("0\n");
                } else {
                    sb.append(Integer.toString(pq.poll()) + "\n");
                }
            } else {
                pq.add(input);
            }
        }
        System.out.println(sb);

        br.close();

    }
}