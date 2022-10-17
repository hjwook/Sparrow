package p11279;

import java.util.Scanner;

public class Main {
    public static void push(int[] heap) {

        return;
    }

    public static int pop(int[] heap) {
        return 0;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[] heap = new int[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                sb.append(Integer.toString(pop(heap)) + "\n");
            } else {
                push(heap);
            }
        }
        sc.close();
    }
}
