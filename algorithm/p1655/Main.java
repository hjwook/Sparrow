package p1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        // 최소힙, 최대힙 하나씩 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            // minHeap 과 maxHeap의 사이즈가 같은경우
            if (minHeap.size() == maxHeap.size()) {
                // minHeap.peek 보다 입력이 크다면, minheap.peek과 input swap
                if (minHeap.size() > 0 && input > minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(input);
                } // 아닌경우 maxHeap 에 add
                else {
                    maxHeap.add(input);
                }
            } else {
                // maxHeap.peek 보다 입력이 작다면, maxHeap.peek과 input swap
                if (maxHeap.size() > 0 && input < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(input);
                } // 아닌경우 minHeap 에 add
                else {
                    minHeap.add(input);
                }
            }
            // maxHeap.peek()이 중간값
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}

// 최대힙 최소힙
// 5 5
// 2 -99 10 7
// 1