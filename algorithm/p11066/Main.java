package p11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static int[] fileSize;

    public static int minCost(int index) {

        return 0;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] inputs = input.split(" ");

            int cost = 0;
            fileSize = new int[K];

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int j = 0; j < inputs.length; j++) {
                fileSize[j] = Integer.parseInt(inputs[j]);
                minHeap.add(Integer.parseInt(inputs[j]));
            }

            while (minHeap.size() > 1) {
                int num1 = minHeap.poll();
                int num2 = minHeap.poll();

                cost += (num1 + num2);
                minHeap.add(num1 + num2);
            }
            sb.append(cost).append("\n");
            // sb.append(minCost(K));

        }

        System.out.println(sb);
        br.close();
    }
}
// 30 30 40 50 20 20
// 40
// 30 30 40 50
// 40 60
// 40 50
// 80 60
// 50
// 80 110
// 190

// 3+6+9+6+9 = 33
// 1 2 3 4 5
// 3 3 4 5
// 6 4 5
// 6 9
// 15
