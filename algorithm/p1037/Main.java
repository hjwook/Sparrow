package p1037;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int max = 0;
        // 진짜 약수들이 주어졌을때 찾아야할 N은 진짜 약수 최소값 x 진짜약수 최대값
        for (int i = 0; i < num; i++) {
            int temp = sc.nextInt();
            if (temp < min) {
                min = temp;
            }
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(min * max);
        sc.close();
    }
}
