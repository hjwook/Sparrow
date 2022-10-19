package p11279;

import java.util.Scanner;

public class Main {
    public static int heapSize = 0;

    public static void push(int[] heap, int x) {
        heap[++heapSize] = x;
        int i = heapSize;
        // 비교할 부모가 있을때까지 반복
        while (i / 2 >= 1) {
            // 최대 힙이므로, 부모가 자식보다 작다면 swap
            if (heap[i] > heap[i / 2]) {
                int temp = heap[i / 2];
                heap[i / 2] = heap[i];
                heap[i] = temp;
            }
            // 부모가 자식보다 클 경우 비교 정지.
            else {
                break;
            }
            i /= 2;
        }
        return;
    }

    public static int pop(int[] heap) {
        if (heapSize == 0) {
            return 0;
        }

        int top = heap[1];
        heap[1] = heap[heapSize];
        heap[heapSize] = 0;//
        heapSize--;
        int i = 1;
        // heapSize까지 반복
        while (i * 2 <= heapSize) {
            int leftChild = heap[i * 2];
            int rightChild = heap[i * 2 + 1];
            if (heap[i] < leftChild) {
                if (rightChild > leftChild) {
                    int temp = heap[i * 2 + 1];
                    heap[i * 2 + 1] = heap[i];
                    heap[i] = temp;
                    i = i * 2 + 1;
                } else {
                    int temp = heap[i * 2];
                    heap[i * 2] = heap[i];
                    heap[i] = temp;
                    i = i * 2;
                }
            } else {
                if (heap[i] < rightChild) {
                    int temp = heap[i * 2 + 1];
                    heap[i * 2 + 1] = heap[i];
                    heap[i] = temp;
                    i = i * 2 + 1;
                }
                // 자식들보다 크면 break
                else {
                    break;
                }
            }
        }
        return top;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[] heap = new int[N + 2];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                sb.append(Integer.toString(pop(heap)) + "\n");
            } else {
                push(heap, x);
            }
        }
        System.out.println(sb);
        sc.close();
    }
}
